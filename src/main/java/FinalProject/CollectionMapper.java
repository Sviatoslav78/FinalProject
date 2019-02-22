package FinalProject;

import java.io.IOException;
import java.util.*;

public class CollectionMapper implements JsonMapper<Collection<?>> {

    //creates record of objects classes implements Collection
    @Override
    public void write(Collection<?> obj, MyJsonWriter writer) {
        try {
            writer.writeArrayBegin();
            for (Object objElement : obj) {
                if (objElement.getClass().getName().contains("java")) {
                    //check affiliations with class Boolean
                    if (objElement.getClass().equals(Boolean.class)) {
                        new BooleanMapper().write((Boolean) objElement, writer);
                        //check affiliations with class String
                    } else if (objElement.getClass().equals(String.class)) {
                        new StringMapper().write((String) objElement, writer);
                        //check affiliations with class Character
                    } else if (objElement.getClass().equals(Character.class)) {
                        new StringMapper().write(objElement.toString(), writer);
                        //check affiliations with class Number
                    } else if (objElement.getClass().getSuperclass().equals(Number.class)) {
                        new NumberMapper().write((Number) objElement, writer);
                        //check affiliations with class AbstractMap
                    } else if (objElement.getClass().getSuperclass().equals(AbstractMap.class)) {
                        new MapMapper().write((Map) objElement, writer);
                        //check affiliations with abstract Classes of interface Collection
                    } else if (objElement.getClass().getSuperclass().equals(AbstractList.class)
                            || objElement.getClass().getSuperclass().equals(AbstractSet.class)) {
                        new CollectionMapper().write((AbstractList) objElement, writer);
                        //check affiliations with PrimitiveTypes[]
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

