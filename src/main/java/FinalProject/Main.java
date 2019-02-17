package FinalProject;

import DwarfBand.model.Dwarf;
import com.google.gson.Gson;

import java.io.Writer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String a = "Hello";
        new MyJsonSerializer().serialize(a, new MyJsonWriter());
    }
}
