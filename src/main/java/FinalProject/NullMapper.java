package FinalProject;

import java.io.IOException;

public class NullMapper implements JsonMapper {
    @Override
    public void write(Object obj, MyJsonWriter writer) {
        try {
            writer.writeNull();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
