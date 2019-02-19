package FinalProject;

public class BooleanMapper implements JsonMapper <Boolean>{

    @Override
    public void write(Boolean obj, MyJsonWriterStream writer) {
        writer.writeBoolean (obj);
        writer.flush();
    }
}
