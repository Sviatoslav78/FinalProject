package Core;

import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("Mama");
        a.add("papa");

        File file = new File("Test.txt");
        ObjectElement objectElement = new ObjectElement();
        System.out.println(objectElement.checkObject(a));
    }
}
