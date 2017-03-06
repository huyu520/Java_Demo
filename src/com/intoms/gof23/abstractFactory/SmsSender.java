package com.intoms.gof23.abstractFactory;

public class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("i'm " + this.getClass().getName() + "sender");
	}
}
