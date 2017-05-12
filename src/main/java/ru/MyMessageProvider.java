package ru;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Di on 12.05.2017.
 */
public class MyMessageProvider
{

    public Connection createConnection() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                                    new ActiveMQConnectionFactory("vm://localhost");

        return activeMQConnectionFactory.createConnection();
    }


    public void sendMessage(String message)
    {
        try {
            Connection connection = createConnection();

            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);



            Destination destination = session.createQueue("MyQueue");
            MessageProducer messageProducer = session.createProducer(destination);

            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//
            // persistent from not persistent depend from speed. Persistent save messages so it more slow..

            TextMessage textMessage = session.createTextMessage("Server: " + message);

            messageProducer.send(textMessage);

            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
