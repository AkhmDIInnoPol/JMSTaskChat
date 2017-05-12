package ru;

import sun.dc.pr.PRError;

/**
 * Created by Di on 12.05.2017.
 */
public class ClientThread extends Thread
{
    private static int id = 0;
    private int thisId = 0;
    MyMessageConsumer consumer;

    public ClientThread()
    {
        ++id;

         consumer = new MyMessageConsumer(id);
        thisId = id;
        System.out.println(id);
    }

    @Override
    public void run() {


        consumer.receiveMessage();



    }
}
