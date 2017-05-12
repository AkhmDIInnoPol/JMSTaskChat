package ru;

/**
 * Created by Di on 12.05.2017.
 */
public class Client1Thread extends Thread
{


    @Override
    public void run() {
        MyMessageConsumer consumer = new MyMessageConsumer();

        while (true)
        {
            consumer.receiveMessage();

        }

    }
}
