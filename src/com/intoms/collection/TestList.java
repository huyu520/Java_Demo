package com.intoms.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestList {

	public static void main(String[] args) {
//		testMap();
		test1();
	}
	
	public static void test1(){
		List<Person> li = new ArrayList<Person>();
		li.add(new Person("huyu", 1));
		li.add(new Person("timo", 2));
		li.add(new Person("sisi", 6));
		li.add(new Person("sha", 4));
		
		Collections.sort(li);
		System.out.println(li);
		Collections.reverse(li);
		System.out.println(li);
//		System.out.println(li.subList(0, li.size() - 2));
		Iterator<Person> it = li.iterator();
		
		int rank = 1 ;
		Map<String, Integer> map = new HashMap<>();
		while(it.hasNext()){
			Person value = it.next() ;
			map.put(value.getName(), rank);
			System.out.println("名字：" + value.getName() + "id:" + value.getId() +"  "+ "排名：" + rank) ;
			rank++;
		}
		
		System.out.println(map.get("timo"));
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(2);
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
	}
	public static void testMap(){
		Map<String, String> map = new HashMap<>() ;
		map.put("001", "22122");
		map.put("002", "21222");
		map.put("0201", "22222");
		map.put("0301", "223222");
		for(Entry<String, String> entry : map.entrySet()){
			String key = entry.getKey() ;
			String value = entry.getValue() ;
			System.out.println("key="+key + "|value" + value );
		}
	}

}
