package com.thinking.in.java.charcter5;

public class TestConstructor {
	String name ;
	public TestConstructor(){
	}
	
	public TestConstructor(String str){
		this.name = str ;
	}
	public static void main(String[] args) {
		TestConstructor t1 = new TestConstructor() ;
		TestConstructor t2 = new TestConstructor("ss");
		System.out.println(t1.name);
		System.out.println(t2.name);
	}
}
