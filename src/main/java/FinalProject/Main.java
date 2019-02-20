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
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(6);
        list.add(8);

        ArrayList list2 = new ArrayList();
        list.add(3);
        list.add(6);
        list.add(8);

        ArrayList list3 = new ArrayList();
        list.add(3);
        list.add(6);
        list.add(8);

        Map<ArrayList,Integer> map=new HashMap<>();
        map.put(list,7);
        map.put(list2,1);
        map.put(list3,2);

//        for (int i = 0; i < 5; i++) {
//            new Thread(new MyJsonSerializer().serialize(map)).start();
//        }
////
        MyJsonSerializer myJsonSerializer = new MyJsonSerializer();
        System.out.println(myJsonSerializer.serialize(map));

        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
    }
}
