package com.zsl.msg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author zsl
 * @date 2019/10/27
 * 生产者
 */
public class Test1 {


    public static void main(String[] args) throws Exception {

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

        //5、创建生产者
        MessageProducer producer = session.createProducer(queue);
        //6、设置消息
        for (int i = 0; i < 3 ; i++) {
            //7、创建消息
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("我是你爹--->"+i);
            //8、发送消息到中间件
            producer.send(textMessage);
        }
        //9、关闭
        producer.close();
        session.close();
        connection.close();
        System.out.println("发送到中间件成功！");
    }
}
