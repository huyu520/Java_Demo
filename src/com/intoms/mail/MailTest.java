package com.intoms.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 发送邮件的demo
 * @author Administrator
 *
 */
public class MailTest {
	public static void main(String[] args) {
		sendMail(); 
	}
	public static void sendMail() {
		//接受者
		String to = "hy@intoms.cn";
		//发送者
		String from = "web@email.com";
		// 指定发送邮件的主机为 localhost
		String host = "127.0.0.1" ;
		 // 获取系统属性
		Properties properties = System.getProperties() ;
		 // 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		//获得session对象
		Session session = Session.getDefaultInstance(properties);
		// 创建默认的 MimeMessage 对象
		MimeMessage message = new MimeMessage(session) ;
		try {
			message.setFrom(new InternetAddress(from));
	  // Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 // Set Subject: 头部头字段
			message.setSubject("this is my first email demo");
			message.setText("this body is my email content!");
			Transport.send(message);
			System.out.println("Send message successfully....");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		};
	}
}
