package FinalProject;

@FunctionalInterface
public interface JsonMapper<T> {
    //метод, принимает обьект и проверяет его принадлежность к мапперу
    void write(T obj, MyJsonWriter writer);
}
