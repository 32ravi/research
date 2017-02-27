package performance;

import java.util.HashMap;
import java.util.WeakHashMap;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class WeakHashMapDemo {

	static class Data {
        String value;
        Data(String value) {
            this.value = value;
        }
    }

	public static void main(String[] args) {

		weakHashMapExample();
		hashMapExample();
	}

	
	/*
	 * RSN SUPER IMP -- In regular HashMap the Keys object are strongly reachable from the map. 
	 * After adding someDataObject inside the map, even if we set someDataObject=null; this is only setting the 
	 * referene variable to null, this is not doing anything to the memory where someDataOjbect was pointing.
	 * 
	 * In weakHashMap keys have only weak reference, so if *NO* other variable outside the hashMap is holding onto
	 * the Keys object, that specific hashMap entry will be collected during gc.
	 * 
	 * In regular hashMap Keys are strongly reachable, so once you add an entry in the hashMap, that entry is 
	 * going to be in the map forever till you call remove on that entry.
	 *  doesn't matter if there is any variable outside the hashMap	  holding or not holding the reference 
	 *  of Key object, entries are *NEVER* going to be collected till you call remove on that entry.
	 */
	private static void weakHashMapExample() {

		// -- Fill a weak hash map with one entry
		WeakHashMap<Data, String> map = new WeakHashMap<Data, String>();
		Data someDataObject = new Data("foo");
		map.put(someDataObject, someDataObject.value);
		System.out.println("map contains someDataObject ? " + map.containsKey(someDataObject));

		// -- now make someDataObject elligible for garbage collection...
		someDataObject = null;

		
		for (int i = 0; i < 10; i++) {
			if (map.size() != 0) {
				System.out.println("At iteration " + i + " the map still holds the reference on someDataObject:" + map.toString());
			} else {
				System.out.println("somDataObject has finally been garbage collected at iteration " + i + ", hence the map is now empty");
				break;
			}
			if(i == 4){
				System.out.println("Starting gc.....");
				System.gc();
			}
		}
		
	}

	private static void hashMapExample(){
		// -- Fill a ash map with one entry
		
		System.out.println("----Strong HashMap Example-----");
		HashMap<Data, String> map = new HashMap<Data, String>();
		Data someDataObject = new Data("foo");
		map.put(someDataObject, someDataObject.value);
		System.out.println("map contains someDataObject ? " + map.containsKey(someDataObject));

		// -- now make someDataObject elligible for garbage collection...
		someDataObject = null;

		for (int i = 0; i < 10; i++) {
			if (map.size() != 0) {
				System.out.println("At iteration " + i + " the map still holds the reference on someDataObject");
			} else {
				System.out.println("somDataObject has finally been garbage collected at iteration " + i + ", hence the map is now empty");
				break;
			}
			if(i == 4){
				System.out.println("Starting gc.....");
				System.gc();
			}
		}
		
	}
	

}