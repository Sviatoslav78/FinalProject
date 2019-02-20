package Element;

import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class JsonArray {
    public static void main(String[] args) {


        final int SIZE = 1000;

        Thread t[] = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread((new R()));
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Singleton.counter);
    }
}

class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {

   public final static Object sync = new Object();

    public static int counter = 0;
    private static volatile Singleton instance = new Singleton();

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (sync) {
                if(instance==null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
}
