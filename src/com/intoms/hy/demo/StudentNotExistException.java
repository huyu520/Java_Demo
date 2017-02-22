package com.intoms.hy.demo;

public class StudentNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7180866006530568823L;
	/**
	 * 自定义学生找不到异常
	 * */
	public StudentNotExistException(String msg) {
		super(msg) ;
	}
}
