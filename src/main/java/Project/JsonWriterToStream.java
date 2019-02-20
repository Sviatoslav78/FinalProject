package Project;

import com.google.gson.Gson;

import java.io.*;

public class JsonWriterToStream {

    Writer out = new Writer() {
        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {

        }

        @Override
        public void flush() throws IOException {

        }

        @Override
        public void close() throws IOException {

        }
    };

    public static void main(String[] args) {
        String a = "Hello";
        Gson gson = new Gson();
        String b = gson.toJson(a);
        //стринга не должена возвращаться
    }

}
