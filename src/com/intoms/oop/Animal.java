/**
 * 
 */
package com.intoms.oop;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月9日下午8:49:15
 */
public abstract class Animal {
	
	private String eye ;
	private String age ;

	public abstract String excuteActivity();
	
	public abstract String excute();
	
	public abstract void printMsgLog();

	public String getEye() {
		return eye;
	}

	public void setEye(String eye) {
		this.eye = eye;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
