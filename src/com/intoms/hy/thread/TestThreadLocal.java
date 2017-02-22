/**
 * 
 */
package com.intoms.hy.thread;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月16日上午11:48:43
 */
public class TestThreadLocal {
	public static void main(String[] args) {
		//启动两个线程，两个线程同时共享一个ThreadLocal
		Account account = new Account("初始名");
		
		//虽然两个线程共享同一个账户，即只有一个账户名，但由于帐户名是ThreadLocal类型的，所以每个线程都拥有各自账户名的副本
		new MyThread(account, "线程甲").start();
		new MyThread(account, "线程乙").start();
	}
}
