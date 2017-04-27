package com.intoms.Thread.test;

public class TicketWindowTest extends Thread{

	//static修饰的i即大家共享的，只要有一个地方修改了，那么任何使用该变量的地方跟着修改。
	static int ticket = 20 ;
	static Object key = "key" ;
	
	public TicketWindowTest(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while ( ticket > 0 ) {
			//使用同一个锁，进入的人会吧锁放手上，出来后才把锁放出来
			synchronized (key) {
				if(ticket > 0 ){
					System.out.println(this.getName() + "买出来第" + ticket + "张票");
					ticket--;
				}else {
					System.out.println("票卖完了");
				}
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		TicketWindowTest t1 = new TicketWindowTest("窗口1");
		TicketWindowTest t2 = new TicketWindowTest("窗口2");
		TicketWindowTest t3 = new TicketWindowTest("窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}
