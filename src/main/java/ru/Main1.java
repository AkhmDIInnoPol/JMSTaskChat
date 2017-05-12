package ru;

import java.util.Scanner;

/**
 * Created by Di on 12.05.2017.
 */
public class Main1
{

    public static void main(String[] args) {





        ServerThread serverThread = new ServerThread();
        Client1Thread client1Thread = new Client1Thread();

        serverThread.start();
        client1Thread.start();



    }
}
