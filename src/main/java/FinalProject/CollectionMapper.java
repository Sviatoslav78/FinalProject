package FinalProject;

import java.util.Collection;

public class CollectionMapper implements JsonMapper<Collection> {
    @Override
    public void write(Collection obj, MyJsonWriterStream writer) {
        // ArrayList
        writer.writeArrayBegin();
        for (Object objElement : obj) {
            if (objElement.getClass().equals(String.class)) {
                new StringMapper().write((String)objElement,writer);
            } else if (objElement.getClass().getSuperclass().equals(Number.class)) {
                writer.writeNumber((Number) objElement);
            } else if (objElement.getClass().equals(Boolean.class)) {
                writer.writeBoolean((Boolean) objElement);
            } else if (objElement.getClass().equals(Character.class)) {
                writer.writeString(objElement.toString());
            }
            writer.writeSeparator();
        }
        writer.writeArrayEnd();
        writer.flush();
    }
}
