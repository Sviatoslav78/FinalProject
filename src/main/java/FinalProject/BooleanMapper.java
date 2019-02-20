package FinalProject;

import java.io.IOException;

public class BooleanMapper implements JsonMapper<Boolean> {

    //creates record of Boolean.class objects
    @Override
    public void write(Boolean obj, MyJsonWriter writer) {
        try {
            if (obj == true) {
                writer.writeBoolean("true");
            }
            if (obj == false) {
                writer.writeBoolean("false");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
