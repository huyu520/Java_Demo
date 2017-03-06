package com.intoms.jdbc;

public class User {
	
	private String name ;
	private String password ;
	private int age ;
	private double height;
	
	public User(){
	}
	
	public User(String name, String password, int age, double height) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
