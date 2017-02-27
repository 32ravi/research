package performance;

/*
Never call java.lang.Number subclasses valueOf(String) methods. If you need a primitive value – call parse[Type]. 
If you want an instance of a wrapper class, still call parse[Type] method and rely on the JVM-implemented boxing. 
It will support caching of most frequently used values. 
Never call wrapper classes constructors – they always return a new Object, thus bypassing the caching support.
 Here is the summary of caching support for primitive replacement classes:
Byte, Short, Long
Character
Integer
Float, Double
From -128 to 127
From 0 to 127
From -128 to java.lang.Integer.IntegerCache.high or 127, whichever is bigger
No caching

Pasted from <http://java-performance.info/java-lang-byte-short-integer-long-character-boxing-and-unboxing/> 

 */

public class AutoBoxing {

	public static void main(String[] args) {
		
		// RSN NOTE -- Integer values -127 to 128 boxed are cached
		Integer i1 = 122; //note boxing Good
		Integer i2 = 122;
		System.out.println( "i1==i2 :" + (i1==i2) ); //NOTE BOxing is memory friendly

		// RSN NOTE -- valueOf does Boxing. GOOD for Performance <-- NOTE
		Integer aa = Integer.valueOf("10"); //note BOXING GOOD
		Integer bb = Integer.valueOf(10);
		System.out.println("valueOf is Good; doing autobosing... aa == bb " + (aa == bb));

		// RSN NOTE -- AVOID BELOW, Don't use "new Integer() or new Long()
		Integer ia1  = new Integer(122); //note NO BOXING, Not good
		Integer ia2 = new Integer(122);
		System.out.println( "ia1==ia2 :" + (ia1==ia2) ); //NOTE new Integer will always create new obj on heap; will not use cached values.
		
		
		//NOTE Only values upto 128 are cached; unless you set Djava.lang.Integer.IntegerCache.high=4000 
		Integer i3 = 129;
		Integer i4 = 129;
		System.out.println( "i3==i4 :" + (i3==i4) ); //false
		
		//NOTE which option is best for performance?  parseInt, because parseInt returns primitive int; valueOf creates Integer object
		Integer a = Integer.valueOf("1"); //returned Integer is autoboxed
		int b = Integer.parseInt("1"); //returns primitive int, good for performance
		
		int x = i3.intValue(); //Note AUTOUNBOXING
	}

}
