package FinalProject;

public class NumberMapper implements JsonMapper <Number> {

    //creates record of Number.class objects
    @Override
    public void write(Number obj, MyJsonWriterStream writer) {
        writer.writeNumber(obj);
        writer.flush();
    }
}
