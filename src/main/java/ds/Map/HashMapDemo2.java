package ds.Map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo2 {

	public static void main(String[] args) {

		Map<String, String> mapCountryCodes = new HashMap<String,String>();

		mapCountryCodes.put("1", "abc");
		mapCountryCodes.put("1", "USA");
		mapCountryCodes.put("44", "United Kingdom");
		mapCountryCodes.put("33", "France");
		mapCountryCodes.put("81", "Japan");

		mapKeyIterator(mapCountryCodes);

		mapValues(mapCountryCodes);

		mapEntrySet(mapCountryCodes);

		forEachAndLambdaOnMap(mapCountryCodes);
		
		synchronizedMap(mapCountryCodes);
		
		//The clear() method removes all mappings from the map. The map will be empty and ready to reuse after this
		mapCountryCodes.clear();
		System.out.println("map after clear: " + mapCountryCodes);

	}
	
	
	/*
	 * keySet(): returns a Set view of
	 *  the keys contained in the map. Hence we can iterate over the keys of the map as shown in the following example:
	 */
	private static void mapKeyIterator(Map<String,String> mapCountryCodes){

		System.out.println("Map KeySet Iterator....");
		Set<String> setCodes = mapCountryCodes.keySet();
		Iterator<String> iterator = setCodes.iterator();
		 
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    String country = mapCountryCodes.get(code);
		 
		    System.out.println(code + " => " + country);
		}
		
	}
	
	/*
	 * values(): returns a collection of values contained in the map.
	 *  Thus we can iterate over values of the map like this:
	 */
	private static void mapValues(Map<String,String> mapCountryCodes){
		System.out.println("Map Values--------");
		
		Collection<String> valuesCollection = mapCountryCodes.values();
		for(String country: valuesCollection){
			System.out.println(country);
		}
	}
	
	/*
	 * entrySet(): returns a Set view of the mappings contained in this map.
	 *  Therefore we can iterate over mappings in the map like this
	 */
	private static void mapEntrySet(Map<String,String> mapCountryCodes){
		System.out.println("Map Entry SET DEMO-------");
		Set<Map.Entry<String, String>> mapEntries = mapCountryCodes.entrySet(); //====NOTE=====>>> NOTE Map.Entry
		
		for(Map.Entry<String, String> entry : mapEntries){
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}

	private static void forEachAndLambdaOnMap(Map<String,String> mapCountryCodes){
		System.out.println("ForEach + Lambda on Map-----");
		mapCountryCodes.forEach((code, name) ->  System.out.println( code + "==>" +name));

	}
	
	/*
	 * Unlike the legacy Hashtable which is synchronized, the HashMap, TreeMap and LinkedHashMap are not synchronized.
	 *  If thread-safe is priority, consider using ConcurrentHashMap in place of HashMap.
	 *   Or we can use the Collections.synchronizedMap() utility method that returns a synchronized (thread-safe) map backed by the specified map. 
	 */
	private static void synchronizedMap(Map<String,String> mapCountryCodes){
		Map<String,String> synchMap = Collections.synchronizedMap(mapCountryCodes);
	}
	
}
