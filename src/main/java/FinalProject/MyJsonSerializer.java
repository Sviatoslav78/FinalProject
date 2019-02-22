package FinalProject;

import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyJsonSerializer implements Serializable {

    static Lock lock = new ReentrantLock();

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
        if (choice == 1) writer = new MyJsonWriter((Writer) writerAppend);
        else if (choice == 2) writer = new IndentedJsonWriter((Writer) writerAppend);

        if (obj.getClass().getName().contains("java")) {
            Class objMapper = Singleton.INSTANCE.getMapper(obj.getClass());
            //write Boolean
            if (objMapper.equals(BooleanMapper.class)) {
                new BooleanMapper().write((Boolean) obj, writer);
                //write String and Character
            } else if (objMapper.equals(StringMapper.class)) {
                if (obj.getClass().equals(String.class)) new StringMapper().write((String) obj, writer);
                else new StringMapper().write(obj.toString(), writer);
                //write Number
            } else if (objMapper.equals(NumberMapper.class)) {
                new NumberMapper().write((Number) obj, writer);
                //write Map
            } else if (objMapper.equals(MapMapper.class)) {
                new MapMapper().write((Map) obj, writer);
                //write Collection
            } else if (objMapper.equals(CollectionMapper.class)) {
                new CollectionMapper().write((Collection) obj, writer);
                //write Arrays
            } else if (objMapper.equals(PrimitiveArrayMapper.class)) {
                new PrimitiveArrayMapper().write((Object[]) obj, writer);
            } else if (objMapper.equals(ObjectArrayMapper.class)) {
                new ObjectArrayMapper().write((Object[]) obj, writer);
            }
            //write POJO-custom class
        } else {
            new PojoMapper().write(obj, writer);
        }
    }
}