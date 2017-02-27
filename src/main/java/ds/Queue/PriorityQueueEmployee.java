package ds.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * You can notice that always an Employee of lowest salary is removed.
 *  That means, head element always contains Employee object with lowest salary. 
 *  ‘Employee‘ objects in ‘pQueue‘ are placed in the ascending order of their salary.
 */
public class PriorityQueueEmployee {
	

	static class Employee
	{
	    String name;
	 
	    int salary;
	 
	    //Constructor Of Employee
	 
	    public Employee(String name, int salary)
	    {
	        this.name = name;
	 
	        this.salary = salary;
	    }
	 
	    @Override
	    public String toString()
	    {
	        return name+" : "+salary;
	    }
	}
	
	static class MyComparator implements Comparator<Employee>
	{
	    @Override
	    public int compare(Employee e1, Employee e2)
	    {
	        return e1.salary - e2.salary; //====NOTE=====>>>Who will be at the top lowest salary or highest?
	        //return e2.salary - e1.salary;  //====NOTE=====>>>Who will be at the top lowest salary or highest?
	        
	        /*
	        return e1.salary - e2.salary; //====NOTE=====>>>IMP this will put lowest salary employee at the top
	        //return e2.salary - e1.salary;  //====NOTE=====>>>IMP this will put highest salary employee at the top
	         */
	    }
	    
	}
	
	public static void main(String[] args) {
		 //Instantiating MyComaparator
		 
        MyComparator comparator = new MyComparator();
 
        //Creating PriorityQueue of Employee objects with MyComparator as Comparator
 
        PriorityQueue<Employee> pQueue = new PriorityQueue<Employee>(7, comparator); //====NOTE=====>>> Constructor definition with generic
        
        //Adding Employee objects to pQueue
 
        pQueue.offer(new Employee("AAA", 15000));  //====NOTE=====>>> IMP Look at the source code 
 
        pQueue.offer(new Employee("BBB", 12000));
 
        pQueue.offer(new Employee("CCC", 7500));
 
        pQueue.offer(new Employee("DDD", 17500));
 
        pQueue.offer(new Employee("EEE", 21500));
 
        pQueue.offer(new Employee("FFF", 29000));
 
        pQueue.offer(new Employee("GGG", 14300));
 
        //Removing the head elements
 
        System.out.println(pQueue.poll());       //Output --> CCC : 7500
 
        System.out.println(pQueue.poll());       //Output --> BBB : 12000
 
        System.out.println(pQueue.poll());       //Output --> GGG : 14300
 
        System.out.println(pQueue.poll());       //Output --> AAA : 15000
 
        System.out.println(pQueue.poll());       //Output --> DDD : 17500
 
        System.out.println(pQueue.poll());       //Output --> EEE : 21500
 
        System.out.println(pQueue.poll());       //Output --> FFF 

	}

}
