/**
 * 
 */
package com.intoms.hy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月13日下午3:01:34
 */
public class TestString {
	public static void main(String[] args) {
//		String num = "1234";
//		test1(num);
//		test(num);
		testArray();
	}
	
//	public static void test(String num){
//		char[] ch = num.toCharArray();
//		System.out.println("----------------字符数组：" +   );
		
//	}
	/**方式1：显然这样设计是有问题的**/
	public static void test1(String num){
		List<String> list = new LinkedList<>();
		for(int i = 0 ;i < num.length() ; i++ ){
			char ch = num.charAt(i);
			list.add(String.valueOf(ch));
		}
		System.out.println("----------" +list );
		
		StringBuilder sb = null ;
		List<String> test = new ArrayList<>() ;
		for(int i = 0 ; i < 1000 ; i ++ ){
			sb = new StringBuilder() ;
			for(int j = 0 ; j < list.size() ; j ++ ){
				sb.append(list.get(j));
			}
			if(!test.contains(sb.toString())){
				test.add(sb.toString());
			}
			Collections.shuffle(list);
		}
		
		System.out.println(test);
	}
	public static void test1(){
		String testStr = "1234abcdsdsdsd###23^12!@#$..";
		int number = 0 , alp = 0 ,other = 0;
//		Map<String, Integer> mapNum = new HashMap<>() ;
//		Map<String, Integer> mapAlp = new HashMap<>() ;
//		Map<String, Integer> mapOther = new HashMap<>() ;
		
		System.out.println("-----------------" + testStr + "------------------");
		for(int i = 0 ; i < testStr.length() ; i++){
			char ch = testStr.charAt(i);
			if('0' <= ch && '9' >= ch){
				number ++ ;
//				mapNum.put(ch, mapNum.)
			}else if('a' <=ch && ch <= 'z'){
				alp ++;
			}else {
				other ++ ;
			}
		}
		System.out.println("该字符中含有数字:" + number );
		System.out.println("该字符中含有字母:" + alp );
		System.out.println("该字符中含有其他字符:" + other );
	}
	
	public static void testArray(){
		String string = "123456";
		char[] ch = string.toCharArray() ;
		System.out.println(String.valueOf(ch));
		String ssString = Arrays.toString(ch);
		System.out.println(ssString);
		
	}
	
//	/**从数组中移除一个元素***/
//	public static void removeElements(){
//		int[] in = {1,2,3};
//		int[] in1 = A
//	}
	
}
