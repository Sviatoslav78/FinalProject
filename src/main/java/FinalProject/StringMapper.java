package FinalProject;

import java.io.IOException;

public class StringMapper implements JsonMapper <String> {

    //creates record of String.class and Character.class objects
    @Override
    public void write(String obj, MyJsonWriter writer) {
        try {
            writer.writeString((String) obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
