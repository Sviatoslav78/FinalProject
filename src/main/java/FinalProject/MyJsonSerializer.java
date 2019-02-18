package FinalProject;

import javax.lang.model.type.PrimitiveType;
import java.util.*;

public class MyJsonSerializer {
    static Map<Class, Class> mappersCache = new HashMap<>();

    static {
        mappersCache.put(Boolean.class, BooleanMapper.class);
        mappersCache.put(Number.class, NumberMapper.class);
        mappersCache.put(String.class, StringMapper.class);
        mappersCache.put(Map.class, MapMapper.class);
        mappersCache.put(ArrayList.class, CollectionMapper.class);
        mappersCache.put(Vector.class, CollectionMapper.class);
        mappersCache.put(LinkedList.class, CollectionMapper.class);
        mappersCache.put(Stack.class, CollectionMapper.class);
        mappersCache.put(PriorityQueue.class, CollectionMapper.class);
        mappersCache.put(HashSet.class, CollectionMapper.class);
        mappersCache.put(LinkedHashSet.class, CollectionMapper.class);
        mappersCache.put(TreeSet.class, CollectionMapper.class);
        mappersCache.put(Object[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Object[].class, ObjectArrayMapper.class);
    }

    protected String serialize(Object obj) {
        MyJsonWriterString myJsonWriterString = new MyJsonWriterString();
        if (obj == null) {
            myJsonWriterString.writeNull();
        } else {
            Class objMapper = getMapper(obj.getClass());
            if (objMapper.equals(StringMapper.class)) {
                myJsonWriterString.writeString((String) obj);
            } else if (objMapper.equals(BooleanMapper.class)) {
                myJsonWriterString.writeBoolean((Boolean) obj);
            } else if (objMapper.equals(NumberMapper.class)) {
                myJsonWriterString.writeNumber((Number) obj);
            } else if (objMapper.equals(MapMapper.class)) {

            } else if (objMapper.equals(CollectionMapper.class)) {

            } else if (objMapper.equals(PrimitiveArrayMapper.class)) {

            } else if (objMapper.equals(ObjectArrayMapper.class)) {

            } else {

            }
        }
        return myJsonWriterString.stringBuilder.toString();
    }

    protected void serialize(Object obj, MyJsonWriterStream writer) {
        //проверить для кастомного класса (getDeclaringClass()???)
        if (obj == null) {
            new NullMapper().write(null, writer);
        } else {
            Class objMapper = getMapper(obj.getClass());
            if (objMapper.equals(StringMapper.class)) {
                new StringMapper().write((String) obj, writer);
            } else if (objMapper.equals(BooleanMapper.class)) {
                new BooleanMapper().write((Boolean) obj, writer);
            } else if (objMapper.equals(NumberMapper.class)) {
                new NumberMapper().write((Number) obj, writer);
            } else if (objMapper.equals(MapMapper.class)) {
                new MapMapper().write((Map) obj, writer);
            } else if (objMapper.equals(CollectionMapper.class)) {
                new CollectionMapper().write((Collection) obj, writer);
            } else if (objMapper.equals(PrimitiveArrayMapper.class)) {
                new PrimitiveArrayMapper().write((Object[])obj, writer);
            } else if (objMapper.equals(ObjectArrayMapper.class)) {
                new ObjectArrayMapper().write((Object[]) obj, writer);
            } else {
                new PojoMapper().write(obj, writer);
            }
        }
    }

    protected Class getMapper(Class clazz) {
        return mappersCache.get(clazz);
    }
}
