package Project;

import Project.Good.JsonWriterToString;

import java.io.Writer;
import java.util.Map;

public class JsonSerializer {
    static Map<Class, JsonMapper> mappersCache; //кэш мапперов:

    protected void serialize(Object obj, Writer writer) {

        //– внутри дергает getMapper, потом дергает сам маппер
    }


//    protected static JsonMapper getMapper(Class clazz){
//
//
//        //метод должен быть потоко-безопасным. Пытается
//        //достать мапер из кеша, если его там нет, то анализирует тип, и для него создает
//        //PojoMapper.
//
//    }
}
