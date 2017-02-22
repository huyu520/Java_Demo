/**
 * 
 */
package com.intoms.hy.thread;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月16日上午11:44:27
 */
public class MyThread  extends Thread{
	private Account account ;
	
	public MyThread(Account account ,String name ) {
		super(name);
		this.account = account ;
	}
	@Override
	public void run() {
		//循环十次
		for(int i = 0 ; i < 10 ; i ++ ){
			if(i == 6){
				this.account.setName(getName());
			}
			System.out.println(account.getName() + "账户i的值" + i);
		}
	}
}
