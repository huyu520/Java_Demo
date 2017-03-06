package com.intoms.gof23.abstractFactory;

public class SmsSenderFactory implements Provider {

	@Override
	public Sender send() {
		return new SmsSender();
	}
}
