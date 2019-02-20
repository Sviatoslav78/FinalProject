package Project;

import Project.Good.JsonWriterToString;

import java.io.Writer;

public class IndentedJsonWriter extends JsonWriterToString {
    //writer, который расставляет отступы, в виде N пробелов, N
    //конфигурируемое, двоеточие окружено по одному пробелу с обеих сторон, стоят Enter, где
    //надо.
    String indentSize; //N
    int currentLevel;

    public IndentedJsonWriter() {
        indentSize = " ";
        currentLevel = 1;
    }



}
