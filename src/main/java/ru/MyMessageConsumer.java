package ru;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Di on 12.05.2017.
 */
public class MyMessageConsumer
{

    private int id = 0;


    public MyMessageConsumer(int id) {
        this.id = id;
    }

    public Connection createConnection() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory("vm://localhost");

        return activeMQConnectionFactory.createConnection();
    }

    public void receiveMessage()
    {
        try {
            Connection connection = createConnection();

            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);



            Destination destination = session.createTopic("MyQueue");

            MessageConsumer messageConsumer = session.createConsumer(destination);

            messageConsumer.setMessageListener(new MessageListener()
            {
                @Override
                public void onMessage(Message message) {

                    try {
                        if (message != null)
                        {
                            System.out.println( "Client" + id + ": " + ((TextMessage)  message).getText() );
                        }

                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });





        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
