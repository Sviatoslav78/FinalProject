package DwarfBand.model;

import java.util.LinkedList;
import java.util.List;

public class DwarvesBand {
    List<Dwarf> dwarves = new LinkedList<Dwarf>();

    public List<Dwarf> getDwarves() {
        return dwarves;
    }

    public void addDwarf(Dwarf dwarf){
        this.dwarves.add(dwarf);
    }
    // getters & setters
}
