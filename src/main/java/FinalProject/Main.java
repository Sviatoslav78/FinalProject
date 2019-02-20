package FinalProject;

import DwarfBand.model.Dwarf;
import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(5);
        a.add("Hello");
        a.add(true);

        Object[] array = new Object[2];
        array[0] = a;
        array[1] = "Hello";

        for (int i = 0; i < 5; i++) {

        }
        MyJsonSerializer myJsonSerializer = new MyJsonSerializer();
        System.out.println(myJsonSerializer.serialize(array));

        Gson gson = new Gson();
        System.out.println(gson.toJson(array));


    }
}
