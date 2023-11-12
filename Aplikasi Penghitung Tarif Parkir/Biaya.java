import java.time.Duration;
import java.time.LocalTime;

public class Biaya {
  private Kendaraan kendaraan;
  private long jamParkir;

  public Biaya(Kendaraan kendaraan, LocalTime waktuMasuk, LocalTime waktuKeluar) {
        this.kendaraan = kendaraan;
        Duration durasi = Duration.between(waktuMasuk, waktuKeluar);
        this.jamParkir = durasi.toMinutes(); // Menghitung durasi parkir dalam menit
    }

    public int hitungBiaya() {
        String jenis = kendaraan.getJenis();
        int biayaPerJam;

        if (jenis.equals("Mobil")) {
            biayaPerJam = 3000;  // Biaya parkir mobil per jam
        } else if (jenis.equals("Motor")) {
            biayaPerJam = 2000;  // Biaya parkir motor per jam
        } else if (jenis.equals("Bus")) {
            biayaPerJam = 5000;  // Biaya parkir bus per jam
        } else {
            return 0; // Kendaraan tidak valid
        }

        int biayaTotal = (int) Math.ceil((double) jamParkir / 60) * biayaPerJam; // Biaya dibulatkan ke atas per jam
        return biayaTotal;
    }
}
