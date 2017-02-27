package rStrings;
import java.util.regex.Pattern;  
import java.util.Scanner;  
import java.util.regex.Matcher;    
public class IMPRegexExample8{    
    public static void main(String[] args){    
        Scanner sc=new Scanner(System.in);  
        while (true) {    
            System.out.println("Enter regex pattern:");  
            Pattern pattern = Pattern.compile(sc.nextLine());    
            System.out.println("Enter text:");  
            Matcher matcher = pattern.matcher(sc.nextLine());    
            boolean found = false;  
            
            while(!found){
            	found = matcher.find();
            	if(found){
            		System.out.println("I found the text "+matcher.group()+" starting at index "+
            				matcher.start()+" and ending at index "+matcher.end());    
            	}
            	else
            	{
            		System.out.println("Pattern NOT found,Enter text:");
            		matcher = pattern.matcher(sc.nextLine());
            	}
            }
        }    
    }    
}    