package FinalProject;

import java.io.FileWriter;
import java.io.IOException;

public class MyJsonWriterStream extends MyJsonWriterString {

    String name;

    public MyJsonWriterStream(String name) {
        this.name = name;
    }

    public void flush() {
        try {
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.write(super.stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
