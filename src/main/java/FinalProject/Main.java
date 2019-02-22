package FinalProject;


import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add("YO");
        arrayList.add('m');
        arrayList.add(53);

        Object[] map = new Object[]{"Hello","Mama", arrayList};

        MyJsonSerializer myJsonSerializer = new MyJsonSerializer();
        System.out.println(myJsonSerializer.serialize(map));

        Gson gson = new Gson();
        System.out.println("GSON" + gson.toJson(map));

    }
}
