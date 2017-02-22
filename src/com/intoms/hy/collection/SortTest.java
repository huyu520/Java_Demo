/**
 * 
 */
package com.intoms.hy.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月16日下午3:03:37
 */
public class SortTest {
	public static void main(String[] args) {
		sortMapForValue();
	}
	/**根据map的值进行排序**/
	public static void sortMapForValue(){
		Map<String, Integer> map = new HashMap<>() ;
		map.put("A", 55);
		map.put("G", 66);
		map.put("S", 13);
		map.put("R", 228);
		map.put("W", 89);
		
		/**转换成键值对的list*
		 * 重写compare 方法
		 * */
		List<Map.Entry<String, Integer>> li = new ArrayList<>(map.entrySet());
		Collections.sort(li, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2){
				return o2.getValue() - o1.getValue() ;
			}
		});
		System.out.println(li);
	}
}
