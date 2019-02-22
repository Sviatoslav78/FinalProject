package FinalProject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class PojoMapper implements JsonMapper {

    //creates record of custom class
    @Override
    public void write(Object obj, MyJsonWriter writer) {
        try {
            writer.writeObjectBegin();
            for (Field field : obj.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    // check MyJsonIgnore annotation
                    if ((field.isAnnotationPresent(MyJsonIgnore.class))) {
                        continue;
                    }
                    writer.writeString(field.getName());
                    writer.writePropertySeparator();
                    if (field.get(obj) == null) {
                        continue;
                    } else if (field.get(obj).getClass().equals(String.class)) {
                        new StringMapper().write((String) field.get(obj), writer);
                    } else if (field.get(obj).getClass().getSuperclass().equals(Number.class)) {
                        new NumberMapper().write((Number) field.get(obj), writer);
                    } else if (field.get(obj).getClass().getSuperclass().equals(AbstractList.class)) {
                        new CollectionMapper().write((Collection) field.get(obj), writer);
                    } else if (field.get(obj).getClass().getSuperclass().equals(AbstractSet.class)) {
                        new CollectionMapper().write((Collection) field.get(obj), writer);
                    } else if (field.get(obj).getClass().getSuperclass().equals(AbstractMap.class)) {
                        new MapMapper().write((Map) field.get(obj), writer);
                    } else if (field.get(obj).getClass().equals(Boolean.class)) {
                        new BooleanMapper().write((Boolean) field.get(obj), writer);
                    } else if (field.get(obj).getClass().equals(Character.class)) {
                        new StringMapper().write(field.get(obj).toString(), writer);
                    } else if (field.get(obj).getClass().equals(Object[].class)) {
                        new ObjectArrayMapper().write((Object[]) field.get(obj), writer);
                    } else
                        new PojoMapper().write(field.get(obj), writer);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                writer.writeSeparator();
            }
            writer.writeObjectEnd();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
