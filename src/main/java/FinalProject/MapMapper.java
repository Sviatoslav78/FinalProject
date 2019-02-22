package FinalProject;

import java.io.IOException;
import java.util.*;

public class MapMapper implements JsonMapper<Map> {

    //creates record of Map
    @Override
    public void write(Map obj, MyJsonWriter writer) {

        //defined punctuation
        int iterator = 1;

        Set keyMap = obj.keySet();
        Object[] keyArray = keyMap.toArray();

        Collection valueMap = obj.values();
        Object[] valueArray = valueMap.toArray();

        ArrayList list = new ArrayList();
        for (int i = 0; i < keyArray.length; i++) {
            list.add(keyArray[i].toString());
            list.add(valueArray[i]);
        }

        try {
            writer.writeObjectBegin();
            for (Object objElement : list) {
                if (objElement.getClass().getName().contains("java")) {
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
                    } else if (objElement.getClass().getComponentType().getSuperclass().equals(Number.class) ||
                            objElement.getClass().getComponentType().getSuperclass().equals(Character.class)) {
                        new PrimitiveArrayMapper().write((Object[]) objElement, writer);
                    } else {
                        new ObjectArrayMapper().write((Object[]) objElement, writer);
                    }
                    //Pojo
                } else {
                    new PojoMapper().write(objElement.toString(), writer);
                }
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
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

