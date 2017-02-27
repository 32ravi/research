package rStrings;

public class StringGetBytesExample{  
	public static void main(String args[]){  
		String s1="A BCDEFG";  
		byte[] barr=s1.getBytes();  
		for(int i=0;i<barr.length;i++){  
			System.out.println(barr[i]);  
		}  
	}}
