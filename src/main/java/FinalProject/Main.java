package FinalProject;


import com.google.gson.Gson;

import java.util.*;

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

        MyJsonSerializer myJsonSerializer = new MyJsonSerializer();

        Runnable task = () -> {
            System.out.println(myJsonSerializer.serialize(map));
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }

        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
    }
}
