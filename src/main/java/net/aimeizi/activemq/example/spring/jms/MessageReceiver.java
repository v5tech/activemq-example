package net.aimeizi.activemq.example.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			final ObjectMessage objectMessage = (ObjectMessage) message;
			try {
				System.out.println("已接收到服务端发送的jms消息");
				Book book = (Book) objectMessage.getObject();
				System.out.println(book);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"jsm-consumer.xml");
	}

}
