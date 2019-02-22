package FinalProject;

import java.io.IOException;
import java.io.Writer;

public class IndentedJsonWriter extends MyJsonWriter {

    //write symbols with tabs, enters, etc
    int currentLevelOblect = 0;
    int currentLevelArray = 0;

    public IndentedJsonWriter(Writer writer) {
        super(writer);
    }

    @Override
    void writeObjectBegin() throws IOException {
        if (currentLevelOblect == 0){
            writer.write("{" + " \n\t");
            currentLevelOblect++;
        } else {
            writer.write("{");
            currentLevelOblect++;
        }
    }

    @Override
    void writeObjectEnd() throws IOException{
        writer.write( "\b}");
        currentLevelOblect--;
    }

    @Override
    void writeArrayBegin() throws IOException {
        if (currentLevelArray == 0 && currentLevelOblect == 0) {
            writer.write("[" );
            currentLevelArray++;
        }
        else if (currentLevelArray == 0){
            writer.write("[" + "\n" + "    ");
        }
        else {
            writer.write("[");
        }
    }
    @Override
    void writeArrayEnd() throws IOException {
        writer.write("\b]" );
        currentLevelArray--;
    }

    @Override
    void writeString(String s) throws IOException {
        super.writeString(s);
    }

    @Override
    void writeNumber(Number n) throws IOException{
        super.writeNumber(n);
    }

    @Override
    void writeSeparator() throws IOException{
        if (currentLevelOblect == 1 && currentLevelArray == 1) {
            writer.write("," + "\n" + "\t" );
        } else if (currentLevelOblect == 1) {
            writer.write("," + "\n" + "\t");
        }
        //новая
        else if (currentLevelArray ==  0){
            writer.write("," + "\n" );
        } else
            writer.write("," );
    }

    @Override
    void writePropertySeparator() throws IOException {
        writer.write(" : ");
    }

    @Override
    void writeNull() throws IOException{
        super.writeNull();
    }

    @Override
    void writeBoolean(String bool) throws IOException{
        super.writeBoolean(bool);
    }

    @Override
    public void flush() throws IOException{
        super.flush();
    }
}
