package com.zsl.msg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zsl
 * @date 2019/10/28
 */
public class ActiveMqTopicConsumer {
    public static void main(String[] args) throws Exception {
        System.out.println("我是3号消费者");
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(MyConst.CONNECTION_URL);
        // 创建连接 并连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //创建session
        Session session = connection
                .createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建目的地Destination，队列还是主题
        Topic topic = session.createTopic(MyConst.TOPIC_NAME);

        //创建消费者
        MessageConsumer consumer = session.createConsumer(topic);


        // 使用监听器的方式来消费消息
        /*consumer.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("****消费者接收消息：" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });*/

        consumer.setMessageListener((message)->{
            if (null != message && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("****消费者接收消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
