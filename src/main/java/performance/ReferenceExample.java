package performance;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;


/*
Learn - WeakReference
 Soft Reference: If an object has no strong reference but has a soft reference, 
 then the garbage collector reclaims this object’s memory when GC needs to free up some memory. 
 To get Object from a soft reference, one can invoke the get() method. 
 If the object is not GCed, it returns the object, otherwise , it returns null.

Weak Reference: If an object has no strong reference but has a weak reference 
then GC reclaims this object’s memory in next run even though there is enough memory. 

Phantom Reference: If an object does not have any of the above references then it may have a phantom reference. 
Phantom references can’t be accessed directly. When using a get() method it will always return null. 
 */

public class ReferenceExample {
       private String status ="Hi I am active";
       
       private String origin;
       
       public ReferenceExample(String orig){
    	   origin=orig;
       }
       
       public String getStatus() {
              return status;
       }
       public String getOrigin(){
    	   return origin;
       }
       public void setStatus(String status) {
              this.status = status;
       }
       @Override
       public String toString() {
              return "ReferenceExample [status=" + status + "]" + "[origin="+ origin + "]";
       }
       
       public void strongReference()
       {
              ReferenceExample ex = new ReferenceExample("StrongRef");
              
              System.out.println(ex);
       }
       
       //====NOTE=====>>> SoftReferene will be collected only when JVM is running low on memory
       public void softReference()
       {
    	     //====NOTE=====>>> RSN how SoftReference is created
              SoftReference<ReferenceExample> ex = new SoftReference<ReferenceExample>(new ReferenceExample("SoftRef"));
              //====NOTE=====>>> RSN SUPER IMP : Note how to get hold of real object, by get() method
              System.out.println("Soft refrence :: " + ex.get().getOrigin());
              
              int counter=0;
              while(counter<5)
              {
                     counter++;
                     System.gc();
              }
              
              System.out.println("SoftReference still Valid after 5 GC:" + ex.get().getStatus() + "Orig=" + ex.get().getOrigin());
       }
       
       public void weakReference()
       {
              int counter=0;
              //====NOTE=====>>> RSN how weak reference is created
              WeakReference<ReferenceExample> ex = new WeakReference<ReferenceExample>(new ReferenceExample("WeakRef"));
              System.out.println("Weak reference before GC..." + "Origin=" + ex.get().getOrigin());
              while(ex.get()!=null)
              {
                     counter++;
                     System.gc();
                     System.out.println("Weak reference deleted  after:: " + counter +"gc. Value after GC:" + ex.get());
              }
       }
       
       /*
        * If there is a reference to acutal object(realEx below), then weakReference won't be collected.
        */
       public void weakReference_holdingRealObj()
       {
              int counter=0;
              //====NOTE=====>>> RSN how weak reference is created
              WeakReference<ReferenceExample> ex = new WeakReference<ReferenceExample>(new ReferenceExample("WeakRef2"));
              System.out.println("Weak reference before GC..." + "Origin=" + ex.get().getOrigin());
              ReferenceExample realEx = ex.get();
             
              //while(ex.get()!=null)
              while(counter <10)
              {
                     counter++;
                     System.gc();
              }
              System.out.println("Weak reference  after:: " + counter +" GCs. Value after GC:" + ex.get());
       }

       
       public void phantomReference() throws InterruptedException
       {
    	   //====NOTE=====>>> ReferenceQueue from java.lang.ref
              final ReferenceQueue queue = new ReferenceQueue();
              PhantomReference<ReferenceExample> ex = 
            		  new PhantomReference<ReferenceExample>(new ReferenceExample("PhantomRef"),queue);
              
              //====NOTE=====>>> Phantom referene always retursn null, it is hardcoded to null
              System.out.println("Phantom ref before GC..wow where is it: " + ex.get()); 
              System.gc();
              System.out.println("Phatom Ref after GC:" + ex.get() );
              queue.remove();
              System.out.println("Phantom reference deleted  after");
       }
     
       private ReferenceExample getRefrence()
       {
              return new ReferenceExample("n/a");
       }
       public static void main(String[] args) {
              ReferenceExample ex = new ReferenceExample("n/a");
              ex.strongReference();
              ex.softReference();
              ex.weakReference();
              ex.weakReference_holdingRealObj();
              try {
                     ex.phantomReference();
              } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
       }
}
