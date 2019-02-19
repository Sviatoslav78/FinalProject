package FinalProject;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        ArrayList a = new ArrayList();
//        a.add("2");
//        a.add(3);
//        a.add('5');
//        a.add(6);
//        System.out.println(a.getClass().getSuperclass());
//        new MyJsonSerializer().serialize(a, new MyJsonWriterStream("Test2"));
//
//        Gson gson = new Gson();
//        gson.toJson(a);




        Character[] array = new Character[]{2,2,5,4,6,8};

        Class c = array.getClass().getComponentType();
        Class b=Integer.class;

        if(c.equals(b)){
            System.out.println( "number");
        }else{
            System.out.println("No number");
        }

        System.out.println(array.getClass());
//        for (Object o : array) {
//            if (o.equals(Number.class.getFields()) != Number.class) {
//                continue;
//            }
//            else {
//                System.out.println("ок");}
//        }



//        new MyJsonSerializer().serialize(array,new MyJsonWriterStream("Test 2"));
    }
}
