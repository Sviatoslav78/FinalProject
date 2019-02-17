package FinalProject;

public class NullMapper implements JsonMapper {
    @Override
    public void write(Object obj, MyJsonWriterStream writer) {
        writer.writeNull();
        writer.flush();
    }
}
