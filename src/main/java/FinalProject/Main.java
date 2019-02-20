package FinalProject;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        MyJsonSerializer myJsonSerializer = new MyJsonSerializer();

        ArrayList a = new ArrayList();
        a.add(5);
        a.add(6);
        a.add("Hello");
        a.add(true);

        System.out.println(myJsonSerializer.serialize(a));
    }
}
