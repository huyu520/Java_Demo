package com.intoms.javabasic;

public class StringBuilderTest {
	public static void main(String[] args) {
		//int indexOf(String str) ：返回当前StringBuffer对象中，第一个满足str子串的位置。  
		//int indexOf(String str, int fromIndex) ：从fromIndex开始查找，返回第一个满足str子串的位置。 
		
		StringBuilder sb = new StringBuilder("this is my first java Application");
		System.out.println(sb.indexOf("is"));
		System.out.println(sb.lastIndexOf("is"));
		System.out.println(sb.indexOf("is", 4));
	}
}
