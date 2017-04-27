package com.intoms.Thread.test;

public class TicketWindowTest2 implements Runnable{

	static int ticket = 20 ;
	static Object Key = "op";
	
	public TicketWindowTest2() {
		super();
	}
	@Override
	public void run() {
		while(ticket > 0 ){
			synchronized (Key) {
				if(ticket > 0 ){
					System.out.println(Thread.currentThread().getName() + "卖出了" + ticket + "张票");
					ticket--;
				}else {
					System.out.println("票已售完");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TicketWindowTest2  t2 = new TicketWindowTest2();
		Thread thread1 = new Thread(t2, "窗口1");
		Thread thread2 = new Thread(t2, "窗口2");
		Thread thread3 = new Thread(t2, "窗口3");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
