package net.aimeizi.activemq.example.spring.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageSender {

	private JmsTemplate jmsTemplate;

	public MessageSender() {
	}

	public MessageSender(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	public void send(Book book) {
		jmsTemplate.convertAndSend(book);
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jms-producer.xml");
		MessageSender messageSender = (MessageSender) applicationContext.getBean("messageSender");
		Book book = new Book(1, "平凡的世界", "路遥", 98.0f);
		messageSender.send(book);
		System.out.println("jms消息发送...");
		System.exit(0);
	}

}
