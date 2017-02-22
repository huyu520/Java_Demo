/**
 * 
 */
package com.intoms.hy.thread;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月16日上午11:40:03
 */
public class Account {
	//定义一个threadlocal类型的变量
	private ThreadLocal<String> name = new ThreadLocal<>();

	public Account(String str){
		this.name.set(str);
		//下面访问的是当前线程的name的副本值
		System.out.println("----------------" + this.name.get() + "---------------");
	}

	public String getName(){
		return this.name.get();
	}

	public void setName(String name){
		this.name.set(name);
	}
}
