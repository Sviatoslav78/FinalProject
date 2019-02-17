package FinalProject;

import javax.lang.model.type.PrimitiveType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyJsonSerializer {
    static Map<Class, Class> mappersCache=new HashMap<>();

    static {
        mappersCache.put(Boolean.class, BooleanMapper.class);
        mappersCache.put(Number.class, NumberMapper.class);
        mappersCache.put(String.class, StringMapper.class);
        mappersCache.put(Map.class, MapMapper.class);
        mappersCache.put(Collection.class, CollectionMapper.class);
        mappersCache.put(PrimitiveType.class, PrimitiveArrayMapper.class);
        mappersCache.put(Object.class, ObjectArrayMapper.class);
    }

    protected String serialize(Object obj){
        String s=new String();
        return s;
    }


    protected void serialize(Object obj, MyJsonWriter writer) {
         //проверить для кастомного класса (getDeclaringClass()???)
        Class objMapper = getMapper(obj.getClass());
        if(objMapper.equals(StringMapper.class)) {
            new StringMapper().write(obj, writer);
        }
        else if(objMapper.equals(BooleanMapper.class)) {
            new BooleanMapper().write(obj, writer);
        }
        else if(objMapper.equals(NumberMapper.class)) {
            new NumberMapper().write(obj, writer);
        }
        else if(objMapper.equals(MapMapper.class)) {
            new MapMapper().write(obj, writer);
        }
        else if(objMapper.equals(CollectionMapper.class)) {
            new CollectionMapper().write(obj, writer);
        }
        else if(objMapper.equals(PrimitiveArrayMapper.class)) {
            new PrimitiveArrayMapper().write(obj, writer);
        }
        else if(objMapper.equals(ObjectArrayMapper.class)) {
            new ObjectArrayMapper().write(obj, writer);
        }
        else {
            new PojoMapper().write(obj,writer);
        }
    }

    protected Class getMapper(Class clazz) {
      return mappersCache.get(clazz);
    }
}
