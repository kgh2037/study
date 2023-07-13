package study09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class guide {
	public static void main(String[] args) {
		
		System.out.println("======= ArrayList =======");
		List<String> list1 = new ArrayList<String>(); // ArrayList 를 객체화 = 인스턴스 생성
		list1.add("100");
		list1.add("90");
		System.out.println(list1);
		System.out.println(list1.get(0));
		
		System.out.println("-------------------------");
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(20);
		list2.add(80);
		
		List<Double> list3 = new ArrayList<Double>();
		list3.add(20.3);
		list3.add(80.787);
		System.out.println(list3);  // 전체 타입 값 출력
		System.out.println(list3.get(0)); // index 0 출력
		System.out.println(list3.size()); // 요소개수
		System.out.println("-------------------------");
		
		System.out.println("========= Array =========");
		String[] a1 = {"aa", "bb", "cc"};
		System.out.println(a1);
		System.out.println(a1[0]);
		System.out.println(a1.length);
	
		System.out.println("=======+ HashMap +=======");
		Map<String, String> map1 = new HashMap<String, String>();
		
		map1.put("0", "aa");
		map1.put("1", "bb");
		map1.put("2", "cc");
		System.out.println(map1);
		System.out.println(map1.get("1"));
		System.out.println(map1.size());
		System.out.println("-------------------------");
	
		Map<String, String> map2 = new HashMap<String, String>();
		
		map2.put("userid", "kgh2037");
		map2.put("pass", "123456");
		map2.put("birthday", "1996-02-06");
		System.out.println(map2);
		System.out.println(map2.get("userid"));
		System.out.println(map2.size());

		
		System.out.println("========= Array 반복문 =========");
		for(int i = 0; i<a1.length; i++) {
			System.out.println("array[" + i + "] :" + a1[i]);
		}
		
		System.out.println("======= ArrayList 반복문 =======");
		for(int i = 0; i<list1.size(); i++) {
			System.out.println("list[" + i + "] : " + list1.get(i));
		}


		System.out.println("======== HashMap 반복문 ========");
		String key = "";
		String value = "";
		Iterator<String> keys = map2.keySet().iterator();
		while(keys.hasNext()) {
			key = keys.next();
			value = map2.get(key);
			System.out.println(key + " : " + value);
		}
	
	}
}

/*
	ArrayList, HashMap

	ArrayList 는 Array와 같은 배열 성질을 띔으로 호출시 배열 자리 번호로 호출
	HashMap은 key값으로 value를 호출하기 때문에 key값으로 호출


*/

