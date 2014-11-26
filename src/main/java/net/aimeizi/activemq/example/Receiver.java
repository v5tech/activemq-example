package net.aimeizi.activemq.example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 接收消息
 * @author welcome
 *
 */
public class Receiver {

	
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	private static final String BROKERURL = "tcp://localhost:61616";
	
	/***************************apollo*************************************/
	private static final String APOLLO_USERNAME = "admin";
	private static final String APOLLO_PASSWORD = "password";
	private static final String APOLLO_BROKERURL = "tcp://localhost:61613";
	
	public static void main(String[] args) {
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
     	ConnectionFactory connectionFactory;
		
        // Connection ：JMS 客户端到JMS Provider 的连接
     	Connection connection = null;
     	
		// Session： 一个发送或接收消息的线程
        Session session;
        
        // Destination ：消息的目的地.
        Destination destination;
        
        // 消费者，消息接收者
        MessageConsumer consumer;
		
        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        connectionFactory= new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);

        try {
			// 构造从工厂得到连接对象
			connection = connectionFactory.createConnection();
			// 启动
			connection.start();
			// 获取操作连接
			session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
			// 创建消息目的地，从何处接受消息。
			destination = session.createQueue("MyQueue");
			// 创建消息接受对象
			consumer = session.createConsumer(destination);
			while (true) {
			    //设置接收者接收消息的时间，为了便于测试，这里设定为100s
			    TextMessage message = (TextMessage) consumer.receive(100000);
			    if (null != message) {
			        System.out.println("收到" + message.getText());
			    } else {
			        break;
			    }
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
            try {
                if (null != connection){
                	connection.close();
                }
            } catch (Throwable ignore) {
            	
            }
        }
        
	}

}
