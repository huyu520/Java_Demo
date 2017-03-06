package com.intoms.gof23.abstractFactory;

public class Demo {
	
	/**
	 * 抽象工厂
	 * @param args
	 */
	public static void main(String[] args) {
		//子类的对象赋给积累的引用
		Provider provider = new MailSendFactory() ;
		Sender sender = provider.send() ;
		sender.send(); 
		
		provider = new SmsSenderFactory() ;
		sender = provider.send() ;
		sender.send(); 
	}
}
