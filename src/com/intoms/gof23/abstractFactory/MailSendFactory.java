package com.intoms.gof23.abstractFactory;

public class MailSendFactory  implements Provider{

	@Override
	public Sender send() {
		return new MailSender();
	}
}
