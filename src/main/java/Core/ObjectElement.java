package Core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectElement {

    StringBuilder stringBuilder = new StringBuilder();

    public String checkObject(Object element) {
        stringBuilder.append("{");

        if (element.getClass().equals(String.class)
                || element.getClass().equals(Integer.class)
                || element.getClass().equals(Boolean.class)
                || element.getClass().equals(Float.class)
                || element.getClass().equals(Double.class)
                || element.getClass().equals(Byte.class)
                || element.getClass().equals(ArrayList.class)) {
            stringBuilder.append(element);
        } else {
            Class elementClass = element.getClass();

            Field[] fields = elementClass.getFields();

            for (Field field : fields) {
                try {
                    if (field.get(element) != null) {
                        stringBuilder.append(field.getName());
                        stringBuilder.append(" : ");
                        stringBuilder.append(field.get(element) + "\n");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
