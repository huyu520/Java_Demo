package com.intoms.javabasic;

public class TestMD5 {
	public static void main(String[] args) {
		try {
			System.out.println(Util.encoderMD5("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
