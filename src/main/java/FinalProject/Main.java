package FinalProject;


import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(5,7);
        map.put(1,1);
        map.put(2,2);

        MyJsonSerializer myJsonSerializer = new MyJsonSerializer();
        System.out.println(myJsonSerializer.serialize(map));

        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
    }
}
