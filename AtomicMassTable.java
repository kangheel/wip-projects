import java.util.HashMap;

public class AtomicMassTable {
    private static HashMap<String,Double> AtomicMassTable = new HashMap<>();
    public AtomicMassTable() {
        AtomicMassTable.put("H",1.008);
        AtomicMassTable.put("He",4.0026);
        AtomicMassTable.put("Li",6.94);
        AtomicMassTable.put("Be",9.0122);
        AtomicMassTable.put("B",10.81);
        AtomicMassTable.put("C",12.011);
        AtomicMassTable.put("N",14.007);
        AtomicMassTable.put("O",15.999);
        AtomicMassTable.put("F",18.998);
        AtomicMassTable.put("Ne",20.18);
        AtomicMassTable.put("Na",22.99);
        AtomicMassTable.put("Mg",24.305);
        AtomicMassTable.put("Al",26.982);
        AtomicMassTable.put("Si",28.085);
        AtomicMassTable.put("P",30.974);
        AtomicMassTable.put("S",32.06);
        AtomicMassTable.put("Cl",35.45);
        AtomicMassTable.put("K",39.098);
        AtomicMassTable.put("Ca",40.078);
        AtomicMassTable.put("Br",79.904);
        AtomicMassTable.put("Hg",200.59);
        AtomicMassTable.put("Pt",195.08);
        AtomicMassTable.put("Au",196.97);
        AtomicMassTable.put("Ag",107.87);
        AtomicMassTable.put("Fe",55.845);
    }
    public static double get(String element) {
        return AtomicMassTable.get(element);
    }
}