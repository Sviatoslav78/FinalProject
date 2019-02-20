package FinalProject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class ObjectArrayMapper implements JsonMapper<Object[]> {
    @Override
    public void write(Object[] obj, MyJsonWriter writer) {
        try {
            writer.writeArrayBegin();
            for (Object o : obj) {
                if (o.getClass().getSuperclass().equals(AbstractList.class)) {
                    new CollectionMapper().write((Collection) o, writer);
                } else if (o.getClass().getSuperclass().equals(AbstractSet.class)) {
                    new CollectionMapper().write((Collection) o, writer);
                } else if (o.getClass().getSuperclass().equals(AbstractMap.class)) {
                    new MapMapper().write((Map) o, writer);
                } else if (o.getClass().getSuperclass().equals(Number.class)) {
                    writer.writeNumber((Number) o);
                } else if (o.getClass().equals(String.class)) {
                    writer.writeString((String) o);
                } else {
                    new PojoMapper().write(o,writer);
                    }
                writer.writeSeparator();
            }
            writer.writeArrayEnd();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
