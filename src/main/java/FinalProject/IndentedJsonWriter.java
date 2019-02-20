package FinalProject;

import java.io.IOException;
import java.io.Writer;

public class IndentedJsonWriter extends MyJsonWriter {

    //write symbols with tabs, enters, etc

    static int nIncrement = 0;

    public IndentedJsonWriter(Writer writer) {
        super(writer);
    }

    @Override
    void writeObjectBegin() throws IOException {
        if (nIncrement == 0) {
            writer.write("{" + "\n" + "\t");
            nIncrement++;
        } else if (nIncrement > 1) {
            nIncrement = 0;
        } else {
            writer.write("{");
        }
    }

    @Override
    void writeObjectEnd() throws IOException {
        nIncrement--;
        writer.write("\r}");
    }

    @Override
    void writeArrayBegin() throws IOException {
        if (nIncrement == 0) {
            writer.write("[" + "\n" + "\t");
            nIncrement++;
        } //else if (nIncrement == 1){ }
        else {
            writer.write("[");
        }
    }

    @Override
    void writeArrayEnd() throws IOException {
        nIncrement--;
        writer.write("\r]");
    }

    @Override
    void writeSeparator() throws IOException{
        if(nIncrement == 1) {
            writer.write("," + "\n" + "\t");
            nIncrement--;
        } else if (nIncrement == 0) {
            writer.write("\n" +"\t");
        } else if (nIncrement < 0) {
            nIncrement = 1;
        } else
            writer.write("," );
    }

    @Override
    void writePropertySeparator() throws IOException {
        writer.write(" : ");
    }
}



