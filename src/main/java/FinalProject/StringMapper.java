package FinalProject;

public class StringMapper implements JsonMapper <String> {

    @Override
    public void write(String obj, MyJsonWriterStream writer) {
        writer.writeString((String) obj);
        writer.flush();
    }

}
