package com.intoms.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String , Integer> map = new HashMap<>() ;
		map.put("1", 11);
		map.put("1.0", 11);
		map.put("1.", 11);
		map.remove("re");
		System.out.println(map);
		System.out.println(map.get("res") + "|" +map.size());
		Collection<Integer> obj = map.values() ;
		int sum = 0 ;
		for(Integer in : obj){
			if(in == null ){
				continue ;
			}
			sum += in.intValue() ;
		}
		System.err.println("sum=" + sum);
	}
}
