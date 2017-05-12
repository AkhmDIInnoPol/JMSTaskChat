package ru;

/**
 * Created by Di on 12.05.2017.
 */
public class Main2
{

    public static void main(String[] args) {

        MyMessageProvider myMessageProvider = new MyMessageProvider();

        myMessageProvider.sendMessage("Hello");

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
