package FinalProject;

import java.io.IOException;

public class PrimitiveArrayMapper implements JsonMapper<Object[]> {
    @Override
    public void write(Object[] obj, MyJsonWriter writer) {
        try {
            writer.writeArrayBegin();
            for (Object o : obj) {
                if (o.getClass().equals(Character.class)) {
                    writer.writeString(o.toString());
                } else {
                    writer.writeNumber((Number) o);
                }
                writer.writeSeparator();
            }
            writer.writeArrayEnd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
