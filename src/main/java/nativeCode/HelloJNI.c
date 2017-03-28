/*
 * HelloJNI.c
 *
 *  Created on: Mar 17, 2017
 *      Author: Ravi
 */

#include <jni.h>
#include <stdio.h>
#include "nativeCode_HelloJNI.h"

//http://www.linuxforums.org/forum/programming-scripting/189473-cpu_zero-cpu_set-funcions-help.html
//Below line is for CPU_ZERO macro errors
#ifndef __USE_GNU
#define __USE_GNU
#endif

//For scheduling related header
#include <sched.h>
#include <sys/syscall.h>


#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/utsname.h>
#include <fcntl.h>
#include <unistd.h>


//Implementation of native method sayHello

//reference site : https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html

JNIEXPORT jint JNICALL Java_nativeCode_HelloJNI_sayHello(JNIEnv *env, jobject thisObj, jint i){
	printf("Hello World --!!");
	return i*i;
}


JNIEXPORT jstring JNICALL Java_nativeCode_HelloJNI_jniStringDemo(JNIEnv *env, jobject thisObj, jstring inJNIStr){
	// Step 1: Convert the JNI String (jstring) into C-String (char*)
	//String is an object in java whereas it is char array in C, so String conversion is little compliecated
	const char *inCStr = (*env)->GetStringUTFChars(env, inJNIStr, NULL);
	if (NULL == inCStr) return NULL;

	// Step 2: Perform its intended operations
	printf("In C, the received string is: %s\n", inCStr);
	(*env)->ReleaseStringUTFChars(env, inJNIStr, inCStr);  // release resources

	// Prompt user for a C-string
	char outCStr[128];
	printf("Enter a String: ");
	scanf("%s", outCStr);    // not more than 127 characters

	// Step 3: Convert the C-string (char*) into JNI String (jstring) and return
	return (*env)->NewStringUTF(env, outCStr);
}

//Demo for passing primitive array from Java
JNIEXPORT jdoubleArray JNICALL Java_nativeCode_HelloJNI_sumAndAverage
(JNIEnv *env, jobject thisObj, jintArray inJNIArray) {

	// Step 1: Convert the incoming JNI jintarray to C's jint[]
	jint *inCArray = (*env)->GetIntArrayElements(env, inJNIArray, NULL);
	if (NULL == inCArray) return NULL;
	jsize length = (*env)->GetArrayLength(env, inJNIArray);

	// Step 2: Perform its intended operations
	jint sum = 0;
	int i;
	for (i = 0; i < length; i++) {
		sum += inCArray[i];
	}
	jdouble average = (jdouble)sum / length;
	(*env)->ReleaseIntArrayElements(env, inJNIArray, inCArray, 0); // release resources

	jdouble outCArray[] = {sum, average};

	// Step 3: Convert the C's Native jdouble[] to JNI jdoublearray, and return
	jdoubleArray outJNIArray = (*env)->NewDoubleArray(env, 2);  // allocate
	if (NULL == outJNIArray) return NULL;
	(*env)->SetDoubleArrayRegion(env, outJNIArray, 0 , 2, outCArray);  // copy
	return outJNIArray;
}

JNIEXPORT void JNICALL Java_nativeCode_HelloJNI_modifyInstanceVariable
(JNIEnv *env, jobject thisObj){
	// Get a reference to this object's class
	jclass thisClass = (*env)->GetObjectClass(env, thisObj);

	// int
	// Get the Field ID of the instance variables "number"
	jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "number", "I");
	if (NULL == fidNumber) return;

	// Get the int given the Field ID
	jint number = (*env)->GetIntField(env, thisObj, fidNumber);
	printf("In C, the int is %d\n", number);

	// Change the variable
	number = 99;
	(*env)->SetIntField(env, thisObj, fidNumber, number);

	// Get the Field ID of the instance variables "message"
	jfieldID fidMessage = (*env)->GetFieldID(env, thisClass, "message", "Ljava/lang/String;");
	if (NULL == fidMessage) return;

	// String
	// Get the object given the Field ID
	jstring message = (*env)->GetObjectField(env, thisObj, fidMessage);

	// Create a C-string with the JNI String
	const char *cStr = (*env)->GetStringUTFChars(env, message, NULL);
	if (NULL == cStr) return;

	printf("In C, the string is %s\n", cStr);
	(*env)->ReleaseStringUTFChars(env, message, cStr);

	// Create a new C-string and assign to the JNI string
	message = (*env)->NewStringUTF(env, "Hello from C");
	if (NULL == message) return;

	// modify the instance variables
	(*env)->SetObjectField(env, thisObj, fidMessage, message);
}

//similar to   setScheduler(
JNIEXPORT void JNICALL Java_nativeCode_HelloJNI_setSchedulerPolicyAndPriority(JNIEnv *env, jobject thisObj){

	pid_t tid = syscall( SYS_gettid );

	printf("IN C, scheduler setting for pid %d\n.....", tid);
	int current= 23;
	current = sched_getscheduler(tid);
	printf("Current scheduler...%d\n",current );

	struct sched_param schedParam;
	schedParam.sched_priority = 30; //priority

	int ret = sched_setscheduler(tid,SCHED_RR, &schedParam);

	//int ret = sched_setscheduler(tid,SCHED_RR, &schedParam);

	if(ret != 0){
		printf("IN C, scheduler setting FAILED, return error number: %d\n", errno);
		printf("error description: %s\n", strerror(errno));
	}else{

		printf("IN C, scheduler setting complete");
	}

}


/*
 * Method:    assignToProcessorSetHelper in SchedulingUtilityLinux.
 * http://stackoverflow.com/questions/10490756/how-to-use-sched-getaffinity2-and-sched-setaffinity2-please-give-code-samp
 */
JNIEXPORT void JNICALL Java_nativeCode_HelloJNI_assignCPUAffinityAndProcessorSet
  (JNIEnv * env, jobject instance, jint  cpuRequired)
{
	printf("In C: starting CPU affinity ....\n");
	pid_t tid = syscall( SYS_gettid );

	cpu_set_t my_set; /* Define your cpu_set bit mask. */
	CPU_ZERO(&my_set); /* Initialize it all to 0, i.e. no CPUs selected. */
	CPU_SET(cpuRequired, &my_set); //set the bit that represents core 2
	int ret = sched_setaffinity(tid, sizeof(cpu_set_t), &my_set);

	if( ret == 0){ // 0 is success
		printf("CPU affinity successful\n");
	}
	else{
		printf("CPU affinity FAILED\n");
	}
}

