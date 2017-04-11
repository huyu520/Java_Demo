package com.thinking.in.java.charcter3;

public class TestDog {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.name = "hy";
		dog1.say = "haha" ;
		Dog dog2 = new Dog() ;
		dog2.name = "timo" ;
		dog2.say = "come on" ;
		System.out.println("dog1:" + dog1.name + "|" + dog1.say);
		System.out.println("dog2:" + dog2.name + "|" + dog2.say);
		
		Dog dog3 = dog2 ;
		//== 比较的是对象的引用，equals 默认也是比较的是对象的引用，如果要比较内容，则需重写对象的equals方法
		System.out.println(dog3 == dog2);
		System.out.println(dog3.equals(dog2));
	}
}
class Dog{
	String say ;
	String name ;
}