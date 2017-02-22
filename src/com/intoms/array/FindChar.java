package com.intoms.array;

import java.util.Arrays;

public class FindChar {
	public static void main(String[] args) {
		/*案例1 : 统计一个字符在字符串中的所有位置.
		　　字符串: 统计一个字符在字符串中的所有位置*/
		String str = "吃豆腐不吃豆腐渣";
		char key = '吃';
		System.out.println(Arrays.toString(find(str, key)));
	}
	
	public static int[] find(String str ,char key){
		int[] arry = {};
		for(int i =0 ;i < str.length() ;i++){
			char c = str.charAt(i);
			if(key == c){
				arry = Arrays.copyOf(arry, arry.length+1);
				arry[arry.length-1] = i ;
			}
		}
		return arry;
	}
 }
