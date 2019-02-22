package FinalProject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
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
        writer.append("{");
    }

    //если предыдущий символ – запятая, удаляет его
    void writeObjectEnd() throws IOException {
        writer.append("\b");
        writer.append("}");
    }

    void writeArrayBegin() throws IOException {
        writer.append("[");
    }

    //если предыдущий символ – запятая, удаляет его
    void writeArrayEnd() throws IOException {
        writer.append("\b");
        writer.append("]");
    }

    //данный метод принимает стрингу, при необходимости ескейпит внутри символы, добавляет с обеих сторон «“»
    void writeString(String s) throws IOException {
        writer.append("\"");
        writer.append(s);
        writer.append("\"");
    }

    //записывает в низ лежащий поток число
    void writeNumber(Number n) throws IOException {
        writer.append(n.toString());
    }

    //добавляет запятую
    void writeSeparator() throws IOException {
        writer.append(",");
    }

    //добавляет двоеточие «:»
    void writePropertySeparator() throws IOException {
        writer.append(":");
    }

    void writeBoolean(String b) throws IOException {
        writer.append(b);
    }

    void writeNull() throws IOException {
        writer.append("null");
    }

    void flush() throws IOException {
        writer.flush();
    }
}

