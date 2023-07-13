package study09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BoardListMap {
	
	public static void test1(List<Map> list) {
		for(int i=0; i<list.size(); i++) {
			Map<String,String> map = new HashMap<String,String>();
			map = list.get(i);
		Iterator<String>keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next(); 
			String value = map.get(key);
			if(key.equals("rdate")) {
				// .split() - 제거 > array 삽입 > string으로 변환하는 방법
//				String[] array = value.split("-");
//				String str = array[0] + array[1] + array[2];
//				value = str;
				// .replace() - > 공백으로 치환
				value = value.replace("-", "");
				map.put("rdate", value);
			} else if(key.equals("hit")) {
				int value2 = Integer.parseInt(value);
				value = value2+100 + "";
				map.put("hit", value);
			}
//			System.out.println(key + ":" + value);
		} 
	}System.out.println(list);
	}
	
	public void test(String a) {
		
	}
	public static void main(String[] args) {
		
		List<Map> list = new ArrayList<Map>();
		Map<String,String> board = new HashMap<String,String>();
		
		board.put("no", "1");
		board.put("hit", "35");
		board.put("rdate", "2021-05-01");
		board.put("name", "홍길동");
		board.put("title", "공지사항1");
		list.add(board);
		
		board = new HashMap<String,String>();
			board.put("no", "2");
			board.put("hit", "3");
			board.put("rdate", "2021-05-05");
			board.put("name", "제임스");
			board.put("title", "공지사항2");
			list.add(board);
			
//상기 메소드 호출 필요
			
	}
}