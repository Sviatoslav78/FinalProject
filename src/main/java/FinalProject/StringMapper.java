package FinalProject;

import java.io.IOException;

public class StringMapper implements JsonMapper <String> {

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
