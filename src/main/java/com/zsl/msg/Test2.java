package com.zsl.msg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zsl
 * @date 2019/10/27
 * 消费者
 */
public class Test2 {

    public static void main(String[] args) throws Exception{
        //1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(MyConst.CONNECTION_URL);
        //2、创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //连接开启
        connection.start();
        //3、创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地destination  queue/topic
        Queue queue = session.createQueue(MyConst.QUEUE_NAME);
        //5、创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (null!=message && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println("****消费者接收消息："+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
