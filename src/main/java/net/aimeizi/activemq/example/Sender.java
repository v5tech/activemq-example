package net.aimeizi.activemq.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 发送消息
 * @author welcome
 *
 */
public class Sender {

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
        
        // Destination ：消息的目的地,消息发送给谁.
        Destination destination;
        
        // MessageProducer：消息发送者
        MessageProducer producer;
		
        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        connectionFactory= new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);
        
		try {
			// 构造从工厂得到连接对象
			connection = connectionFactory.createConnection();
			connection.start();
			
			// 获取操作连接
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            
            // 创建消息队列 消息发送的目的地
            destination = session.createQueue("MyQueue");
			
            // 得到消息生产者即发送者
            producer = session.createProducer(destination);
            
            // 设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            
            // 构造消息，此处写死，项目就是参数，或者方法获取
            try {
				sendMessage(session, producer);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("消息发送失败:"+e.getLocalizedMessage());
			}
            
            session.commit();
            
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	/**
	 * 具体的发送消息业务
	 * @param session
	 * @param producer
	 * @throws Exception 
	 */
	private static void sendMessage(Session session, MessageProducer producer) throws Exception {
		for (int i = 1; i <= 5; i++) {
			TextMessage  message = session.createTextMessage("使用ActiveMQ发送的消息!发送时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			producer.send(message);//发送消息
			System.out.println("----------消息已发送--------------");
		}
	}

}
