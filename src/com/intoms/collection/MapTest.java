/**
 * 
 */
package com.intoms.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月22日下午7:48:08
 */
public class MapTest {
	public static void main(String[] args) {
//		test1(); 
		testList();
	}
	
	public static void test1(){
		String[] array = {"a","b","a","c","b","a","a"};
		Map<String, Integer> map = new HashMap<>();
		for(String s : array){
			if (map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		System.out.println(map);
	}
	
	//*由此也看出linklist 效率 比 arraylist 高 *//
	public static void testList(){
		List<String> li1 = new ArrayList<>() ;
		List<String> li2 = new LinkedList<>() ;
		long t1 = System.currentTimeMillis() ;
		for(int i = 0 ; i < 10000000 ; i++){
			li1.add(""+i);
		}
		long t2 = System.currentTimeMillis() ;
		System.out.println("ArrayList consume time :" + (t2 - t1) + "ms");
		
		long t3 = System.currentTimeMillis() ;
		for(int i = 0 ; i < 10000000 ; i++){
			li2.add(""+i);
		}
		long t4 = System.currentTimeMillis() ;
		System.out.println("LinkList consume time :" + (t4 - t3) + "ms");
	}
}
