package FinalProject;

import java.io.IOException;

public class NumberMapper implements JsonMapper <Number> {

    //creates record of Number.class objects
    @Override
    public void write(Number obj, MyJsonWriter writer) {
        try {
            writer.writeNumber(obj);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
