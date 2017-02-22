/**
 * 
 */
package com.intoms.hy.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	数组转list(测试)
 *  @author hy
 *	Create on 2017年2月15日下午9:13:51
 */
public class ArrayToList {
	public static void main(String[] args) {
		String[] words = {"ace","timo","124"};
		test1(words);
		test2(words);
		test3(words);
	}
	
	/**方法1:直接使用ArrayAsList**/
	public static void test1(String[] words){
		List<String> li = Arrays.asList(words);
		System.out.println(li);
	}
	
	/**方法2：比较死的方法**/
	public static void test2(String[] words){
		List<String> li = new ArrayList<>(words.length);
		for(String word : words ){
			li.add(word);
		}
		System.out.println(li);
	}
	
	/**方法3：直接使用Collection的静态方法addAll方法**/
	public static void test3(String[] words){
		List<String> li = new ArrayList<>() ;
		Collections.addAll(li, words);
		System.out.println(li);
	}
}
