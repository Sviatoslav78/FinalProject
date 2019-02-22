package FinalProject;


import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(5);
        list.add(2);

        ArrayList list2 = new ArrayList();
        list.add(22);
        list.add(22);
        list.add(12);

        ArrayList list3 = new ArrayList();
        list.add(33);
        list.add(64);
        list.add(85);

        HashMap<ArrayList, Integer> map = new HashMap<>();
        map.put(list, 7);
        map.put(list2, 1);
        map.put(list3, 2);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cat");
        arrayList.add("dog");
        arrayList.add("mouse");

        String[] strings = new String[]{"black", "red", "white"};

        Object[] objects = new Object[]{5, list, list2, new Cat("Murzik", 5)};

        Cat cat2 = new Cat("Murzik", 5);

//        Runnable task = () -> {
////            System.out.println(myJsonSerializer.serialize(map));
////        };
////
////        for (int i = 0; i < 10; i++) {
////            new Thread(task).start();
////        }


        HashMap hashMap = new HashMap();
        hashMap.put(2, 5);
        hashMap.put(3, 6);

        Character[] c = new Character[]{'y', 'u', '\u3948'};
        HashSet<Object> b = new HashSet<>();
        System.out.println(b.getClass().getName());
        System.out.println(b.getClass().getName().contains("java"));
        b.add(cat2);
        b.add(5);
        b.add("Man");
        b.add(c);
        b.add(new Integer[]{1,2,3,4,5});
        b.add(new String[]{"Hello","Guys"});
        b.add(new Integer[]{1,2,3,4,5});
        b.add(hashMap);
        Object t = null;
        Object[] o = new Object[]{c, strings};
        b.add(o);

        ArrayList<Object[]> x = new ArrayList<>();
        x.add(new Integer[]{1, 2, 3, 4, 5});
        x.add(new String[]{"Hello", "Guys"});
        x.add(new Integer[]{1, 2, 3, 4, 5});
        b.add(new Object[]{list, cat2, strings});

        //крашится b cat2
        Object[] fin = new Object[]{strings,arrayList,map};


        MyJsonSerializer myJsonSerializer = new MyJsonSerializer();
        System.out.println(myJsonSerializer.serialize(fin));

        Gson gson = new Gson();
        System.out.println("GSON"+gson.toJson(fin));
    }
}
