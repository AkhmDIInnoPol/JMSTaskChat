package ru;

import java.util.Scanner;

/**
 * Created by Di on 12.05.2017.
 */
public class ServerThread extends Thread
{

    @Override
    public void run() {

        MyMessageProvider producer = new MyMessageProvider();

            String mes = "";
            Scanner scan;
            while (true)
            {
                scan = new Scanner(System.in);
                mes = scan.nextLine();
                producer.sendMessage( mes);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
