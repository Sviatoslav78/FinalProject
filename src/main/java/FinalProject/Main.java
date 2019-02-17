package FinalProject;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        ArrayList a = new ArrayList<>();
////        a.add("2");
////        a.add("3");
////        a.add("4");
////        a.add("5");
////        a.add('5');
//        new MyJsonSerializer().serialize(a, new MyJsonWriterStream("Test2"));
        String a = "Hello";
        String f = new MyJsonSerializer().serialize(a);
        System.out.println(f);

        Gson gson = new Gson();
        ArrayList c = new ArrayList();
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");
        c.add('5');
        try {
            FileWriter fileWriter = new FileWriter("Test");
          gson.toJson(c, fileWriter);
           fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
