package study09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {
	public static void main(String[] args) {
	
		Map<String,String> map = new HashMap<String,String>();
		map.put("이름", "홍길동");
		map.put("영어", "90");
		map.put("국어", "10");
		map.put("수학", "70");
											//System.out.println(map3);
			map.put("국어", "80");
			
			int hap = 0;
			Iterator<String> keys = map.keySet().iterator();
			while( keys.hasNext()) {
				String key = keys.next();
				String value = map.get(key);
				if( !key.equals("이름")) {
					hap += Integer.parseInt(value);
				}
			}
			int avg = hap/(map.size()-1);
			System.out.println("총점 : " + hap );
			System.out.println("평균 : " + avg );
	}
}
