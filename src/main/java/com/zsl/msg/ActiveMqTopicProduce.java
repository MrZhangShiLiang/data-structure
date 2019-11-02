package com.zsl.msg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zsl
 * @date 2019/10/28
 * topic模式
 */
public class ActiveMqTopicProduce {

    public static void main(String[] args) throws Exception {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(MyConst.CONNECTION_URL);
        // 创建连接 并连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //创建session
        Session session = connection
                .createSession(true, Session.AUTO_ACKNOWLEDGE);

        //创建目的地Destination，队列还是主题
        Topic topic = session.createTopic(MyConst.TOPIC_NAME);

        // 创建消息的生产者
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 通过使用消息的生产者发送消息到mq的队列里面

        for (int i=1;i<=6;i++){
            //创建消息
            TextMessage textMessage = session
                    .createTextMessage("topic--msg--" + i);
            //通过MessageProducer发送消息
            producer.send(textMessage);
        }

        //关闭连接
        producer.close();
        session.close();
        //使用事务时，需要手动提交事务常常使用的是类似jdbc，try catch finally
        session.commit();
        connection.close();
        System.out.println("*******topic消息发送mq完成****");
    }
}
