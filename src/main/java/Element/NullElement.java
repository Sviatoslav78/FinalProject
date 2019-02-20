package Element;

import java.lang.reflect.Field;
import java.util.*;

public enum NullElement {
    INSTANCE;
    static Map<Class, List<Field>> mapNullElement = new HashMap<>();

    static {
        mapNullElement.put(Class.class, Arrays.asList(Class.class.getFields()));
    }
}
