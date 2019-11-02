package com.zsl.msg;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author zsl
 * @date 2019/10/27
 */
public class ActiveMqConsumer {
    public static String CONNECTION_URL="tcp://118.89.201.12:61616";

    public static String QUEUE_NAME = "queue01";


    public static void main(String[] args) throws Exception{
        System.out.println("我是2号消费者");
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(CONNECTION_URL);
        // 创建连接 并连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //创建session
        Session session = connection
                .createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建目的地Destination，队列还是主题
        Queue queue = session.createQueue(QUEUE_NAME);

        //创建消费者
        MessageConsumer consumer = session.createConsumer(queue);

        // 方法1 同步阻塞方式
        /*while (true){
            TextMessage receive = (TextMessage)consumer.receive(4000L);
            if (null!=receive){
                System.out.println("***消费者接受的消息："
                        +receive.getText());
            }else {
                break;
            }

        }
        consumer.close();
        session.close();
        connection.close();*/
        // 使用监听器的方式来消费消息
        consumer.setMessageListener(new MessageListener(){

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
