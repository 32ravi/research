package ds.Set;

/*
 * Learn
 * How hashSet equal is used to decide duplicates
 * You can notice that hashCode() and equals() methods are overrided in the above class so that two Students objects will be compared solely based on rollNo.
 *  That means, two Student objects having same rollNo will be considered as duplicates irrespective of other fields.
 
 HashSet also gives constant time performance for insertion, removal and retrieval operations.
  It is also important to note that HashSet doesn’t maintain any order. 
  So, It is recommended to use HashSet if you want a collection of unique elements and order of elements is not so important.
 */
import java.util.HashSet;
import java.util.Iterator;

class Student
{
    String name;
 
    int rollNo;
 
    String department;
 
    public Student(String name, int rollNo, String department)
    {
        this.name = name;
 
        this.rollNo = rollNo;
 
        this.department = department;
    }
 
    @Override
    public int hashCode()
    {
    	//return name.hashCode() + rollNo; //RSN change
        return rollNo;
    }

    /*
     * RSN IMP ----->You can notice that hashCode() and equals() methods are overrided in the above class so that two Students objects will be compared solely based on rollNo.
     *  That means, two Student objects having same rollNo will be considered as duplicates irrespective of other fields.
     */
    
    /*
     * RSN IMP - HashMap; first will check if there is any collision on hashCode, if there is A collision in hashCode
       Then check if objects are equal. Overwrite only if objects are equal.

       So a good candidate for hash code should implement BOTH hashCode AND equal method.
        If there is no hashCode Collision, Equal method will NOT be called
     */
    @Override
    public boolean equals(Object obj)
    {
        Student student = (Student) obj;
        System.out.println("Equal is called for " + student.name + " hashCode:" + hashCode());
        Thread.dumpStack();
 
        //return (rollNo == student.rollNo); //====NOTE=====>>> Corect impl
        return (rollNo == student.name.hashCode()); // This is to show how hashCode and Equal are used in hashMap insertion
        //with rull# to name comparision all entry with 301 roll# WILL be entered in hashMap
    }
 
    @Override
    public String toString()
    {
        return rollNo+", "+name+", "+department;
    }
}
 
public class HashSetStudent
{
    public static void main(String[] args)
    {
        HashSet<Student> set = new HashSet<Student>();
 
        //Adding elements to HashSet
 
        set.add(new Student("Avinash", 121, "ECE"));
 
        set.add(new Student("Bharat", 101, "EEE"));
 
        set.add(new Student("Malini", 151, "Civil"));
 
        set.add(new Student("Suresh", 200, "IT"));
 
        set.add(new Student("Vikram", 550, "CS"));
 
        set.add(new Student("Bharat", 301, "IT"));
 
        set.add(new Student("Amit", 301, "IT"));           //duplicate element - Note how are duplicates identified.
 
        set.add(new Student("Bhavya", 872, "ECE"));
 
        set.add(new Student("Naman", 301, "CS"));        //duplicate element
 
        set.add(new Student("Samson", 565, "Civil"));
 
        //Iterating through HashSet
 
        Iterator<Student> it = set.iterator();
 
        while (it.hasNext())
        {
            Student student = (Student) it.next();
 
            System.out.println(student);
        }
        
        System.out.println("Note : there is no ordering in the set");
    }
}