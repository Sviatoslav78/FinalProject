package FinalProject;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;

public class MyJsonWriter {

    //write symbols in line
    Writer writer;

    public MyJsonWriter(Writer writer) {
        if (writer == null) {
            throw new NullPointerException("out == null");
        } else {
            this.writer = writer;

        }
    }

    void writeObjectBegin() throws IOException {
        writer.write("{");
    }

    //если предыдущий символ – запятая, удаляет его
    void writeObjectEnd() throws IOException {
        writer.write("\b");
        writer.write("}");
    }

    void writeArrayBegin() throws IOException {
        writer.write("[");
    }

    //если предыдущий символ – запятая, удаляет его
    void writeArrayEnd() throws IOException {
        writer.write("\b");
        writer.write("]");
    }

    //данный метод принимает стрингу, при необходимости ескейпит внутри символы, добавляет с обеих сторон «“»
    void writeString(String s) throws IOException {
        writer.write("\"");
        writer.write(s);
        writer.write("\"");
    }

    //записывает в низ лежащий поток число
    void writeNumber(Number n) throws IOException {
        writer.write(n.toString());
    }

    //добавляет запятую
    void writeSeparator() throws IOException {
        writer.write(",");
    }

    //добавляет двоеточие «:»
    void writePropertySeparator() throws IOException {
        writer.write(":");
    }

    void writeBoolean(String b) throws IOException {
        writer.write(b);
    }

    void writeNull() throws IOException {
        writer.write("null");
    }

    void flush() throws IOException {
        writer.flush();
    }
}

