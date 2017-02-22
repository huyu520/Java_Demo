package com.intoms.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCompare {
	public static void main(String[] args) {
		methed1();
		methed2();
	}

	public static void methed1() {
		List<Cat> list = new ArrayList<Cat>();
		Cat c = new Cat("a", 10);
		list.add(c);
		c = new Cat("b", 30);
		list.add(c);
		c = new Cat("ca", 20);
		list.add(c);
		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
	}

	public static void methed2() {
		List<Cat> list = new ArrayList<Cat>();
		Cat c = new Cat("a", 10);
		list.add(c);
		c = new Cat("b", 30);
		list.add(c);
		c = new Cat("ca", 20);
		list.add(c);
		
		Comparator<Cat> com = new Cat();
		Collections.sort(list,com);
		System.out.println(list);
		
		com = Collections.reverseOrder(com);
		Collections.sort(list,com);
		System.out.println(list);
	}
}

class Cat implements Comparable<Cat>, Comparator<Cat> {

	private String name;
	private int age;

	public Cat() {
	}

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compare(Cat arg0, Cat arg1) {
		return arg0.getAge() - arg1.getAge();
	}

	@Override
	public int compareTo(Cat arg0) {
		return this.age - arg0.age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "名字:" + this.getName() + "年龄:" + this.getAge();
	}
}
