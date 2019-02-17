package FinalProject;

public class StringMapper implements JsonMapper {

    @Override
    public void write(Object obj, MyJsonWriter writer) {
        writer.writeObjectBegin();
        String a = obj.toString();
        writer.writeString(a);
        writer.writeObjectEnd();
        writer.flush();
    }
}
