package FinalProject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectArrayMapper implements JsonMapper<Object[]> {

    //creates record of Objects array
    @Override
    public void write(Object[] obj, MyJsonWriter writer) {
        try {
            writer.writeArrayBegin();
            for (Object o : obj) {
                if (o.getClass().getName().contains("java")) {
                    //check affiliations with class Boolean
                    if (o.getClass().equals(Boolean.class)) {
                        new BooleanMapper().write((Boolean) o, writer);
                    } else if (o.getClass().equals(String.class)) {
                        new StringMapper().write((String) o, writer);
                    } else if (o.getClass().equals(Character.class)) {
                        new StringMapper().write(o.toString(), writer);
                    } else if (o.getClass().getSuperclass().equals(Number.class)) {
                        new NumberMapper().write((Number) o, writer);
                    } else if (o.getClass().getSuperclass().equals(AbstractList.class)) {
                        new CollectionMapper().write((Collection) o, writer);
                    } else if (o.getClass().getSuperclass().equals(AbstractSet.class)) {
                        new CollectionMapper().write((Collection) o, writer);
                    } else if (o.getClass().getSuperclass().equals(AbstractMap.class)) {
                        new MapMapper().write((Map) o, writer);
                    } else if (o.getClass().getComponentType().equals(Number.class) ||
                            o.getClass().getComponentType().equals(Character.class)) {
                        new PrimitiveArrayMapper().write((Object[]) o, writer);
                    } else {
                        new ObjectArrayMapper().write((Object[]) o, writer);
                    }
                } else {
                        new PojoMapper().write(o.toString(), writer);
                }
                writer.writeSeparator();
            }
            writer.writeArrayEnd();
            writer.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
