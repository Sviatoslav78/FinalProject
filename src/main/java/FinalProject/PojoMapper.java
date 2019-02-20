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
                    if (field.get(obj).getClass().equals(String.class)) {
                        writer.writeString(field.getName());
                        writer.writePropertySeparator();
                        writer.writeString((String) field.get(obj));
                        writer.writeSeparator();
                    } else if (field.get(obj).getClass().getSuperclass().equals(Number.class)) {
                        writer.writeString(field.getName());
                        writer.writePropertySeparator();
                        writer.writeNumber((Number) field.get(obj));
                    }
                    // крешиться, добавить другие типы
                    else if (field.get(obj).getClass().getSuperclass().equals(AbstractList.class)) {
                        new CollectionMapper().write((Collection) obj, writer);
                    } else if (field.get(obj).getClass().getSuperclass().equals(AbstractSet.class)) {
                        new CollectionMapper().write((Collection) obj, writer);
                    } else if (field.get(obj).getClass().getSuperclass().equals(AbstractMap.class)) {
                        new MapMapper().write((Map) obj, writer);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            writer.writeObjectEnd();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
