package DwarfBand.serialize;

import DwarfBand.model.FacialHair;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class FacialHairSerializer implements JsonSerializer<FacialHair> {

    public JsonElement serialize(FacialHair src, Type typeOfSrc, JsonSerializationContext context) {

        if (!src.isHaveBeard() && !src.isHaveMustache()) {
            return new JsonPrimitive("is he really a dwarf?");
        }

        List<String> list = new LinkedList<String>();

        if(src.isHaveBeard()){
            list.add("bear");
        }
        if(src.isHaveMustache()){
            list.add("mustache");
        }

        return new JsonPrimitive(
                new StringBuilder(src.getColor())
                .append(" ")
                .append(StringUtils.join(list, " and "))
                .toString()
        );
    }
}
