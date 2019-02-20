package DwarfBand;

import DwarfBand.model.Dwarf;
import DwarfBand.model.DwarvesBand;
import DwarfBand.model.FacialHair;
import DwarfBand.serialize.DwarfSerializer;
import DwarfBand.serialize.FacialHairSerializer;
import DwarfBand.util.BandUtil;
import Element.Checks;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Checks.INSTANCE.dowork();
//        DwarvesBand band = BandUtil.createBand();
//        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(band);
//        System.out.println(json);
//
//        gson = new Gson().newBuilder().
//                setPrettyPrinting().
//                registerTypeAdapter(Dwarf.class,new DwarfSerializer()).
//                registerTypeAdapter(FacialHair.class,new FacialHairSerializer()).
//                create();
    }
}
