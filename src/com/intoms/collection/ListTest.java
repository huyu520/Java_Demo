/**
 * 
 */
package com.intoms.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月9日下午2:13:29
 */
public class ListTest {
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1(){
		List<Integer> li = new ArrayList<>() ;
		li.add(1);
		li.add(3);
		li.add(2);
		li.add(-1);
		li.add(55);
		li.add(22);
		li.add(23);
		li.add(8);
		li.add(1);
		System.out.println(li);
		Collections.sort(li);
		System.out.println(li);
		Collections.reverse(li);
		System.out.println(li);
		List<Integer> list = new ArrayList<>();
		list.addAll(li.subList(0, li.size() - 5));
		System.out.println(list);
		Object[] arr = list.toArray();
		for(Object object :arr){
			System.out.print(object +" ");
		}
		System.out.println();
		List<Object> sssss= Arrays.asList(arr);
		System.out.println(sssss);
	}
}
