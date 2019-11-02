package com.zsl.msg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zsl
 * @date 2019/10/28
 * 持久化消费者
 */
public class ActiveMqTopicConsumerPersistence {
    public static void main(String[] args) throws Exception {
        System.out.println("我是1号消费者");
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(MyConst.CONNECTION_URL);
        // 创建连接 并连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("1号消费之");

        //创建session
        Session session = connection
                .createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建目的地Destination，队列还是主题
        Topic topic = session.createTopic(MyConst.TOPIC_NAME);

        TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "remark....");

        connection.start();

        Message message = durableSubscriber.receive();

        if (null!=message){
                TextMessage textMessage = (TextMessage)message;
            System.out.println("消费者消费----》"+textMessage.getText());
            Message receive = durableSubscriber.receive(1000L);
        }

//        System.in.read();
//        consumer.close();
        session.close();
        connection.close();
    }
}
