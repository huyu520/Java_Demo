package com.intoms.util;

public class TestPair {
	public static void main(String[] args) {
		String s1 = "123" ;
		String s2 = "12333" ;
		Pair<String, String> pair = new Pair<String, String>(s1, s2);
		String string = test("hy", pair);
		
		System.out.println(string);
		System.out.println(pair.getKey() + "|" + pair.getValue());
	}
	
	public static String test(String s ,Pair<String, String> pair){
		String key = "!111111111111111";
		String value = "!2222222222222";
		pair.setKey(key);
		pair.setValue(value);
		s += "122";
		return s;
	}
}
