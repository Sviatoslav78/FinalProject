import DwarfBand.model.Dwarf;
import DwarfBand.model.FacialHair;
import DwarfBand.model.UniqueWeapon;
import DwarfBand.model.Weapon;
import Element.Element;
import Element.NullElement;
import com.google.gson.Gson;
import sun.reflect.Reflection;
import sun.reflect.ReflectionFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String s = "Am";

        stringBuilder.append(("\""));
        stringBuilder.append(s);
        stringBuilder.append(("\""));
        System.out.println(stringBuilder.toString());
    }
}
