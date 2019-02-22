package FinalProject;

import java.lang.reflect.Field;
import java.util.*;

public enum Singleton {
    INSTANCE;

    static Map<Class, Field[]> mappersCache = new HashMap<>();

    static {
        mappersCache.put(Boolean.class, Boolean.class.getDeclaredFields());
        mappersCache.put(Number.class, Number.class.getDeclaredFields());
        mappersCache.put(String.class, String.class.getDeclaredFields());
        mappersCache.put(Object[].class, Object[].class.getDeclaredFields());
        mappersCache.put(Map.class, Map.class.getDeclaredFields());
        mappersCache.put(Collection.class, Collection.class.getDeclaredFields());
    }

    public Singleton getMappersCache() {
        return INSTANCE;
    }
}
