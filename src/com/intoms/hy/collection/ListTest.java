/**
 * 
 */
package com.intoms.hy.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月15日下午8:43:17
 */
public class ListTest {
	public static void main(String[] args) {
		List<String> list = Collections.synchronizedList(new LinkedList<>());
		list.add("AAA");
		list.add("BBB");
		list.add("AAFF");
		list.add("AAA");
		System.out.println(list);
	}
}
