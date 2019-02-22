package FinalProject;

import java.util.*;

public enum Singleton {
    INSTANCE;

    static Map<java.lang.Class, Class> mappersCache = new HashMap<>();

    //mappersCache key-value
    static {
        //BooleanMapper
        mappersCache.put(Boolean.class, BooleanMapper.class);
        //StringMapper
        mappersCache.put(String.class, StringMapper.class);
        mappersCache.put(Character.class, StringMapper.class);
        //NumberMapper
        mappersCache.put(Integer.class, NumberMapper.class);
        mappersCache.put(Short.class, NumberMapper.class);
        mappersCache.put(Integer.class, NumberMapper.class);
        mappersCache.put(Long.class, NumberMapper.class);
        mappersCache.put(Float.class, NumberMapper.class);
        mappersCache.put(Double.class, NumberMapper.class);
        //MapMapper
        mappersCache.put(HashMap.class, MapMapper.class);
        mappersCache.put(TreeMap.class, MapMapper.class);
        mappersCache.put(LinkedHashMap.class, MapMapper.class);
        //CollectionMapper
        mappersCache.put(ArrayList.class, CollectionMapper.class);
        mappersCache.put(LinkedList.class, CollectionMapper.class);
        mappersCache.put(Vector.class, CollectionMapper.class);
        mappersCache.put(Stack.class, CollectionMapper.class);
        mappersCache.put(ArrayDeque.class, CollectionMapper.class);
        mappersCache.put(PriorityQueue.class, CollectionMapper.class);
        mappersCache.put(HashSet.class, CollectionMapper.class);
        mappersCache.put(LinkedHashSet.class, CollectionMapper.class);
        mappersCache.put(TreeSet.class, CollectionMapper.class);
        //ArrayMappers
        mappersCache.put(Integer[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Short[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Long[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Float[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Double[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Character[].class, PrimitiveArrayMapper.class);
        mappersCache.put(String[].class, ObjectArrayMapper.class);
        mappersCache.put(Object[].class, ObjectArrayMapper.class);
    }

    public Class getMapper(Class clazz){
        return mappersCache.get(clazz);
    }
}
