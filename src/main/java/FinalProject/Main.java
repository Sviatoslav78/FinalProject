package FinalProject;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("2");
        a.add(3);
        a.add('5');
        a.add(6);

        new MyJsonSerializer().serialize(a, new MyJsonWriterStream("Test2"));
    }
}
