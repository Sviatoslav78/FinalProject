package FinalProject;

import com.google.gson.internal.Streams;

import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyJsonSerializer extends Thread {

    static Lock lock = new ReentrantLock();

    static Map<Class, Class> mappersCache = new HashMap<>();

    static {
        mappersCache.put(Boolean.class, BooleanMapper.class);
        mappersCache.put(Character.class, StringMapper.class);
        mappersCache.put(Integer.class, NumberMapper.class);
        mappersCache.put(Byte.class, NumberMapper.class);
        mappersCache.put(Long.class, NumberMapper.class);
        mappersCache.put(Float.class, NumberMapper.class);
        mappersCache.put(Double.class, NumberMapper.class);
        mappersCache.put(String.class, StringMapper.class);
        mappersCache.put(HashMap.class, MapMapper.class);
        mappersCache.put(ArrayList.class, CollectionMapper.class);
        mappersCache.put(Vector.class, CollectionMapper.class);
        mappersCache.put(LinkedList.class, CollectionMapper.class);
        mappersCache.put(Stack.class, CollectionMapper.class);
        mappersCache.put(PriorityQueue.class, CollectionMapper.class);
        mappersCache.put(HashSet.class, CollectionMapper.class);
        mappersCache.put(LinkedHashSet.class, CollectionMapper.class);
        mappersCache.put(TreeSet.class, CollectionMapper.class);
        mappersCache.put(Number[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Character[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Object[].class, ObjectArrayMapper.class);
    }

    protected Class getMapper(Class clazz) {
        if (mappersCache.get(clazz) == null) {
            return PojoMapper.class;
        } else
            return mappersCache.get(clazz);
    }

    public String serialize(Object obj) {
        if (obj == null) {
        } else {
            StringWriter writerAppend = new StringWriter();
            lock.lock();
            // Интерфейс Appendable должен быть реализован любым классом, экземпляры которого предназначаются, чтобы получить отформатированный вывод от a Formatter.
            serialize(obj, (Appendable) writerAppend);
            lock.unlock();
            return writerAppend.toString();
        }
        return null;
    }

    protected void serialize(Object obj, Appendable writerAppend) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, choose the writer:" +
                "\n" + "1. In a line" +
                "\n" + "2. With tabs and enters");
        int choice = scanner.nextInt();
        MyJsonWriter writer = null;
            if (choice == 1) {
                writer = new MyJsonWriter(Streams.writerForAppendable(writerAppend));
            } else if (choice == 2) {
                writer = new IndentedJsonWriter(Streams.writerForAppendable(writerAppend));
            } else if(choice>2){
                serialize(obj);
            }
        if (obj.equals(null)) {
            new NullMapper().write(obj, writer);
        } else {
            Class objMapper = getMapper(obj.getClass());
            if (objMapper.equals(StringMapper.class)) {
                if (obj.getClass().equals(String.class)) {
                    new StringMapper().write((String) obj, writer);
                } else {
                    new StringMapper().write(obj.toString(), writer);
                }
            } else if (objMapper.equals(BooleanMapper.class)) {
                new BooleanMapper().write((Boolean) obj, writer);
            } else if (objMapper.equals(NumberMapper.class)) {
                new NumberMapper().write((Number) obj, writer);
            } else if (objMapper.equals(MapMapper.class)) {
                new MapMapper().write((Map) obj, writer);
            } else if (objMapper.equals(CollectionMapper.class)) {
                new CollectionMapper().write((Collection) obj, writer);
            } else if (objMapper.equals(PrimitiveArrayMapper.class)) {
                new PrimitiveArrayMapper().write((Object[]) obj, writer);
            } else if (objMapper.equals(ObjectArrayMapper.class)) {
                new ObjectArrayMapper().write((Object[]) obj, writer);
            } else {
                new PojoMapper().write(obj, writer);
            }
        }
    }
}
