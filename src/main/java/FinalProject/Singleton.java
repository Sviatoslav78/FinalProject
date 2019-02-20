package FinalProject;

import java.util.*;

public enum Singleton {
    INSTANCE;

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
        mappersCache.put(Number[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Character[].class, PrimitiveArrayMapper.class);
        mappersCache.put(Object[].class, ObjectArrayMapper.class);
    }

    public Map<Class, Class> getMappersCache() {
        return mappersCache;
    }
}
