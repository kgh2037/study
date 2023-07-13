package study09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JumsuArray {

	public static void main(String[] args) {
		List<Map>list = new ArrayList<Map>();
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("id", "test1");
		map.put("eng", "90");
		map.put("kor", "80");
		map.put("math", "84");
		list.add(map);
//		System.out.println(map);
		map = new HashMap<String,String>();
		map.put("id", "test2");
		map.put("eng", "80");
		map.put("kor", "82");
		map.put("math", "90");
		list.add(map);
		
//		System.out.println("list 전체 : " + list);
//		System.out.println("list 행 길이 : " + list.size());
//		System.out.println("list 1행 : " + list.get(0));
//		System.out.println("list 2행 : " + list.get(1));
//		System.out.println("list 1행 길이 : " + list.get(0).size());
//		System.out.println("list 2행 길이 : " + list.get(1).size());
		
		for(int i = 0; i<list.size(); i++) {
			//System.out.println(i+1 + "행 : " + list.get(i) );
			Map<String,String> map1 = new HashMap<String,String>();
			map1 = list.get(i);
			System.out.println(map1);

			Iterator<String>keys = map1.keySet().iterator();
			while(keys.hasNext()) {
				String key = keys.next(); 
				String value = map1.get(key);
				System.out.println(key + ":" + value);
		}		 //foreach문으로 변환해보기!
		}
	}
}