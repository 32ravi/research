package nativeCode;

import java.security.PrivilegedActionException;

/*
 -------- Script to run all compilation
#this script needs to be run from nativeCode directory where java files are present
javac HelloJNI.java
cd ..
javah -d nativeCode -classpath /home/ravin/java-workspace/HelloWorld/src -jni nativeCode.HelloJNI
cd nativeCode
gcc -shared -fpic -o libhello.so -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux HelloJNI.c
echo ".... running jni program...."
java -classpath /home/ravin/java-workspace/HelloWorld/src -Djava.library.path=. nativeCode.HelloJNI

 */
public class HelloJNI {
    
    //instance variables to test
    public  int number = 88;
    public String message = "Java private string";

    static{
        System.loadLibrary("hello");
    }

    //Declare Native method
    private native int  sayHello(int i);
    
    private native String jniStringDemo(String inStr);
    
    private native double[]  sumAndAverage(int[] numbers);
    
    private native void modifyInstanceVariable();
    
    private native void setSchedulerPolicyAndPriority();
    
  //cgroupName; // Possibly null;
   //cgroupSubset; // True if want only some of the CPUs in the CGroup
    private native void assignCPUAffinityAndProcessorSet(int cpuRequired);
    
    public static void main(String[] args) {
        System.out.println("inside Main..."); 
        
        HelloJNI jniObj = new HelloJNI();
       testJNINativeVariablePassing(jniObj);
        
        //testJNI_StringParam(jniObj);
        
        testJNI_ArrayParams(jniObj);
        
        test_ModifyInstanceVariable(jniObj);
        
        test_setSchedulerPolicy_ProcessPriority(jniObj);
        
        test_assignCPUAffinity_ProcessorSet(jniObj);
        
        startLoop();
        
    }
    
    public static void startLoop(){

        int i = 10;
        while(true){
          
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            i = i+i;
            i= i-10;
        }
        
        /*long itr=10000000;
        
        for( i=0; i< itr;){
            i++;
            long  j = i*i;
            long k = j+j; 
        }
        System.out.println("i is:" + i );
*/
        
    }
    
    public static void testJNINativeVariablePassing(HelloJNI jniObj){
        System.out.println("native returned value :" + jniObj.sayHello(2));
        System.out.println("finished calling native code.");
        
    }

    //Passing Strings
    public static   void testJNI_StringParam(HelloJNI jniObj){
        String inStr = "From java";
        System.out.println("String Demo.... passed strin is:" + inStr );
       System.out.println("Returned value from Native code:" +        jniObj.jniStringDemo(inStr));
    }
    
    //Passing Array of Primitives
    public static void testJNI_ArrayParams(HelloJNI jniObj){
        int[] numbers = {10,20,30,40};
        double[] ret = jniObj.sumAndAverage(numbers);
        
        for(int i=0; i < ret.length; i++){
            System.out.println("Native code returned array i:" + i + " value:" + ret[i]);
        }
        
    }
        
        //Accessing Java Object's Variables and Calling Back Methods from inside the native code
        public static void test_ModifyInstanceVariable(HelloJNI jniObj){
            System.out.println("before calling native method local int:" + jniObj.number + " msg:" + jniObj.message  );
            
            jniObj.modifyInstanceVariable();
            
            System.out.println("After calling native method local int:" + jniObj.number + " msg:" + jniObj.message  );
            
        }
        
        //similar to setScheduler( int schedulingClass, int priority ) in SchedulingUtilityLinux tech native package
        public static void test_setSchedulerPolicy_ProcessPriority(HelloJNI jniObj){
            
            jniObj.setSchedulerPolicyAndPriority();
            System.out.println("in Java Process priority setting is called");
        }
        
        /*
         * similar ssignToProcessorSetHelper in SchedulingUtilityLinux. in tech Native dynamic package
         * http://www.gnu.org/software/libc/manual/html_node/CPU-Affinity.html  -- Good article
         */
        
        public static void test_assignCPUAffinity_ProcessorSet(HelloJNI jniObj){
      
            /*int[] cpuSet = {0,1,2,3}; // Is it list of all CPU on the machine or just the one process want affinity
            String configName = "SomeName";
            boolean subSetRequired = false;
            */
            jniObj.assignCPUAffinityAndProcessorSet(2);
            System.out.println("in Java Process cpu affinity is called");
        }

    
}

