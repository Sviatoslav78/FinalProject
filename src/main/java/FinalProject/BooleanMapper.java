package FinalProject;

public class BooleanMapper implements JsonMapper <Boolean>{

    //creates record of Boolean.class objects
    @Override
    public void write(Boolean obj, MyJsonWriterStream writer) {
        writer.writeBoolean (obj);
        writer.flush();
    }
}
