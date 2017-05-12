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
            while (true)
            {

                Scanner scan= new Scanner(System.in);
                mes = scan.nextLine();
                producer.sendMessage( mes);
            }
    }
}
