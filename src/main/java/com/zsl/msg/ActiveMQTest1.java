package com.zsl.msg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zsl
 * @date 2019/10/23
 * activemq的基本使用
 * 生产者代码
 */
public class ActiveMQTest1 {

    public static String CONNECTION_URL="tcp://118.89.201.12:61616";

    public static String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws Exception {
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

        // 创建消息的生产者
        MessageProducer producer = session.createProducer(queue);

        // 通过使用消息的生产者发送消息到mq的队列里面

        for (int i=1;i<=6;i++){
            //创建消息
            TextMessage textMessage = session
                    .createTextMessage("msg--" + i);
            //通过MessageProducer发送消息
            producer.send(textMessage);
        }

        //关闭连接
        producer.close();
        session.close();
        connection.close();
        System.out.println("*******消息发送mq完成****");
    }
}
