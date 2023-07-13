package study09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest1 {
	public static void main(String[] args) {
		Map<String, String>map1 = new HashMap<String, String>();
		map1.put("a", "11");
		map1.put("b", "22");
		map1.put("c", "33");
		
		System.out.println(map1);
		System.out.println(map1.get("a"));
		System.out.println(map1.get("b"));
		System.out.println(map1.get("c"));
		
		Map<String, Integer>map2 = new HashMap<String, Integer>();
		map2.put("a", 11);
		map2.put("b", 22);
		map2.put("c", 33);
		
		System.out.println(map2);
		System.out.println(map2.get("a"));
		System.out.println(map2.get("b"));
		System.out.println(map2.get("c"));

		Map<Integer, String>map3 = new HashMap<Integer, String>();
		map3.put(5, "11");
		map3.put(11, "22");
		map3.put(17, "33");
		System.out.println(map3);
		System.out.println(map3.get(5));
		System.out.println(map3.get(11));
		System.out.println(map3.get(17));
		
		String key = "";
		String value = "";
		
		Iterator<String> keys = map1.keySet().iterator();
		while(keys.hasNext()) {
			key = keys.next();
			value = map1.get(key);
			System.out.println(key + ":" + value);
		}
	}
}
