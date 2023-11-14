// Kelas Kendaraan (Superclass)
public abstract class Kendaraan {
    private String nomorPlat;

    public Kendaraan(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }
    
    public abstract String getJenis();
}
