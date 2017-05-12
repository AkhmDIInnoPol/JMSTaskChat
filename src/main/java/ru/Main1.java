package ru;

/**
 * Created by Di on 12.05.2017.
 */
public class Main1
{

    public static void main(String[] args) {

        ServerThread serverThread = new ServerThread();
        ClientThread clientThread = new ClientThread();
        ClientThread client2Thread = new ClientThread();

        serverThread.start();
        clientThread.start();
        client2Thread.start();
    }
}
