package FinalProject;


import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String,Integer> map=new HashMap<>();
        map.put("Monday",7);
        map.put("Tuesday",1);
        map.put("Wednesday",2);

        Runnable task = () -> {
            System.out.println(new MyJsonSerializer().serialize(map));
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
    }
}
