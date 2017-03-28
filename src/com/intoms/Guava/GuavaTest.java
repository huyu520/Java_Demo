package com.intoms.Guava;

import java.util.HashMap;

import com.google.common.collect.Maps;
/**
 * Guava提供了很多我们常用的数据结构。
 * @author Administrator
 *
 */
public class GuavaTest {
	public static void main(String[] args) {
		HashMap<String, Integer> map = Maps.newHashMap() ;
		
		for(int i = 0 ; i < 10 ; i ++ ){
			map.put("" + i, i);
		}
		System.out.println(map);
	}
}
