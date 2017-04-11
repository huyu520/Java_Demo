package com.intoms.hy.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		Map<String , Integer> map1 = new HashMap<>() ;
		Map<String , Integer> map2 = new HashMap<>() ;
		
		map1.put("hy", 1);
		map1.put("timo", 2);
		map1.put("zz", 3);
		map1.put("gaga", 3);
		map2.put("yy", 3);
		map2.put("hy", 3);
		map2.put("timo", 3);
		map2.put("zz", 3);
		System.out.println(map1);
		System.out.println(map2);
		for(Entry<String, Integer> entry :map2.entrySet()){
			String key = entry.getKey() ;
			if(map1.containsKey(key)){
				map1.put(key, map1.get(key) + entry.getValue() ); 
			}else{
				map1.put(key, entry.getValue());
			}
		}
		System.out.println("map1:--" + map1);
		System.out.println("map2:--" + map2);
		
	}
}
