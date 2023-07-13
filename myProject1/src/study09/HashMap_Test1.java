package study09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMap_Test1 {

	public static void main(String[] args) {
		
		Map<String,Integer>map = new HashMap<String,Integer>();
		int hap = 0;  		
		int avg = 0;        
		
		map.put("영어", 100);
		map.put("국어", 80);
		map.put("수학", 90);
		
		Iterator<String>keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			int value = map.get(key);
				hap += value;
				avg = hap/map.size();
		}
		System.out.println("총점 : " + hap);
		System.out.println("평균 : " + avg);
		System.out.println("============================");
			
		
		
			Map<String,Integer>map2 = new HashMap<String,Integer>();
			
			map2.put("영어", 50);
			map2.put("국어", 40);
			map2.put("수학", 70);

			int hap2 = 0; 
			float avg2 = 0;
			String str = "";
			
			Iterator<String>keys2 = map2.keySet().iterator();
			while(keys2.hasNext()) {
				String key2 = keys2.next();
				int value2 = map2.get(key2);
					hap2 += value2;
					avg2 = (float)hap2/(float)map2.size();
						if(value2 < 60) {
							str += key2 + ",";
					}
			} 
			
			int str_len = str.length(); //while문 안에서 선언한 key2 + "," 의 ,를 제거하기 위한 코드
			str = str.substring(0,str_len-1);
			
			//System.out.printf("평균 : " + avg2);
			String avg2transfer = avg2 + "";
				//int형인 avg2를 String형으로 변환하는 코드
			String[] array = avg2transfer.split("\\.");
				//소숫점을 기준으로 배열에 삽입
				//array[0] = 53 array[1] = 333332
			String avg2print = array[0] + "." + array[1].substring(0,1);
				
			System.out.println("총점 : " + hap2);
			System.out.println("평균 : " + avg2print);
			System.out.println("낙제과목 : " + str);
			System.out.println("============================");
			
				
				
				Map<String,String> map3 = new HashMap<String,String>();
				map3.put("이름", "홍길동");
				map3.put("영어", "90");
				map3.put("국어", "10");
				map3.put("수학", "70");
													//System.out.println(map3);
					map3.put("국어", "80");
													//System.out.println(map3);
				
				String key3 = "";
				int value3 = 0;
				int hap3 = 0;
				int avg3 = 0;
				Iterator<String>keys3 = map3.keySet().iterator();
				while(keys3.hasNext()) {
					key3 = keys3.next();
					value3 = Integer.parseInt(map3.get(key3));
					if(!key3.equals("이름")) {
						
						hap3 += value3;
						avg3 = hap3/map3.size();
					}
				}
				System.out.println("총점 : " + hap3);
				System.out.println("평균 : " + avg3);
				
						
				
					List<String> list = new ArrayList<String>();
					list.add("50");
					list.add("60");
					list.add("70");
					
					int hap4 = 0;
					int avg4 = 0;
					for(int i=0; i<list.size(); i++) {
						hap4 += Integer.parseInt(list.get(i));
						avg4 = hap4/list.size();
					}
					System.out.println("총점 : " + hap4);
					System.out.println("평균 : " + avg4);
	}

}
