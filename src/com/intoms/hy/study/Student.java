package com.intoms.hy.study;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
	private String name ;
	private int age ;
	private ArrayList<String> course ;
	private ArrayList<String> score ;
	
	public Student(String name, int age, ArrayList<String> course) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getCourse() {
		return course;
	}
	public void setCourse(ArrayList<String> course) {
		this.course = course;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public ArrayList<String> getScore() {
		return score;
	}
	public void setScore(ArrayList<String> score) {
		this.score = score;
	}
	@Override
	public String toString() {
		
		return "姓名：\t" + name + "年龄" + age + "分数";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
