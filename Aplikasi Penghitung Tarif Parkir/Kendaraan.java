// Kelas Kendaraan (Superclass)
public class Kendaraan {
    private String nomorPlat;

    public Kendaraan(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }
    
    public String getJenis() {
        return this.getClass().getSimpleName();
    }
}
