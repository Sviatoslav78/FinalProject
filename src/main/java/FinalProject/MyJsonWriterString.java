package FinalProject;

import java.io.FileWriter;
import java.io.IOException;

public class MyJsonWriterString {
    StringBuilder stringBuilder;

    public MyJsonWriterString() {
        stringBuilder = new StringBuilder();
    }

    void writeObjectBegin() {
        stringBuilder.append("{");
    }

    //если предыдущий символ – запятая, удаляет его
    void writeObjectEnd() {
        if (stringBuilder.substring(stringBuilder.length() - 1).contains(",")) {
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "}");
        } else {
            stringBuilder.append("}");
        }
    }

    void writeArrayBegin() {
        stringBuilder.append("[");
    }

    //если предыдущий символ – запятая, удаляет его
    void writeArrayEnd() {
        if (stringBuilder.substring(stringBuilder.length() - 1).contains(",")) {
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "]");
        } else {
            stringBuilder.append("]");
        }
    }

    //данный метод принимает стрингу, при необходимости ескейпит внутри символы, добавляет с обеих сторон «“»
    void writeString(String s) {
        stringBuilder.append(("\""));
        stringBuilder.append(s);
        stringBuilder.append(("\""));
    }

    //записывает в низ лежащий поток число
    void writeNumber(Number n) {
        stringBuilder.append(n.toString());
    }

    //добавляет запятую
    void writeSeparator() {
        stringBuilder.append(",");
    }

    //добавляет двоеточие «:»
    void writePropertySeparator() {
        stringBuilder.append(":");
    }

    void writeBoolean(boolean b) {
        stringBuilder.append(b);
    }

    void writeNull() {
        stringBuilder.append("null");
    }

    public String toString() {
       return stringBuilder.toString();
    }
}

