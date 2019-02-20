package FinalProject;

import java.io.IOException;
import java.util.*;

public class MapMapper implements JsonMapper<Map> {
    @Override
    public void write(Map obj, MyJsonWriter writer) {

        int iterator = 1; //нужен потом, чтобы определить, где ставить двоеточие, а где точку с запятой при серилизации мапы

        Set keyset = obj.keySet();
        Object[] keys = keyset.toArray(); // тк в keyset нет метода get

        Collection values = obj.values();
        Object[] value = values.toArray();
        // по очереди ключ-значение-ключ... записываем list и потом в зависимости от
        // их типа, записываем в стрингбилдер через двоеточя между key:value

        ArrayList list = new ArrayList();

        for (int i = 0; i < keys.length; i++) {
            list.add(keys[i].toString());
            list.add(value[i]);
        }

        try {
            writer.writeObjectBegin();
            for (Object objElement : list) {
                //check affiliations with class String
                if (objElement.getClass().equals(String.class)) {
                    new StringMapper().write((String) objElement, writer);
                    //check affiliations with class Number
                } else if (objElement.getClass().getSuperclass().equals(Number.class)) {
                    new NumberMapper().write((Number) objElement, writer);
                    //check affiliations with class Boolean
                } else if (objElement.getClass().equals(Boolean.class)) {
                    new BooleanMapper().write((Boolean) objElement, writer);
                    //check affiliations with class Character
                } else if (objElement.getClass().equals(Character.class)) {
                    new StringMapper().write(objElement.toString(), writer);
                    //check affiliations with abstract Classes of interface Collection
                } else if (objElement.getClass().getSuperclass().equals(AbstractList.class)
                        || objElement.getClass().getSuperclass().equals(AbstractSet.class)) {
                    new CollectionMapper().write((Collection) objElement, writer);
                    //check affiliations with class AbstractMap
                } else if (objElement.getClass().getSuperclass().equals(AbstractMap.class)) {
                    new MapMapper().write((Map) objElement, writer);
                    //check affiliations with Object[], choose: PrimitiveTypes(without boolean) or Other
                } else if (objElement.getClass().equals(Object[].class)) {
                    if (objElement.getClass().getComponentType().getSuperclass().equals(Number.class) ||
                            objElement.getClass().getComponentType().equals(Character.class)) {
                        new PrimitiveArrayMapper().write((Object[]) objElement, writer);
                    } else {
                        new ObjectArrayMapper().write((Object[]) objElement, writer);
                    }
                    //Pojo
                } else {
                    new PojoMapper().write(objElement.toString(), writer);
                }
                // расставляем запятые и двоеточия
                if (iterator % 2 == 0 && iterator != 0) {
                    writer.writeSeparator();
                }
                if (iterator % 2 != 0 && iterator != 0) {
                    writer.writePropertySeparator();
                }
                iterator++;
            }
            writer.writeObjectEnd();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

