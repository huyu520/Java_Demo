package com.intoms.gof23.abstractFactory;

public class MailSender  implements Sender{

	@Override
	public void send() {
		System.out.println("i'm " + this.getClass().getName() + " sender");
	}
}
