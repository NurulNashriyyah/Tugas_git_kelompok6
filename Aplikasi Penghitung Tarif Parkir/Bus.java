// Kelas Bus (Subclass)
public class Bus extends Kendaraan {
    public Bus(String nomorPlat) {
        super(nomorPlat);
    }
    // Implementasi method abstract
    public String getJenis() {
        return "Bus";
    }
}
