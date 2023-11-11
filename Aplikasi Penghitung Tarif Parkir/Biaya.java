import java.time.Duration;
import java.time.LocalTime;

public class Biaya {
  private Kendaraan kendaraan;
  private long jamParkir;

  public Biaya (Kendaraan kendaraan, LocalTime waktuMasuk, LocalTime waktuKeluar) {
        this.kendaraan = kendaraan;
        Duration durasi = Duration.between(waktuMasuk, waktuKeluar);
        this.jamParkir = durasi.toHours(); // Menghitung durasi parkir dalam jam
  }
  public int hitungBiaya() {
    String jenis = kendaraan.getJenis();
        if (jenis.equals("Mobil")) {
            return (int)(jamParkir + 1) * 3000;  // Biaya parkir mobil per jam
        } else if (jenis.equals("Motor")) {
            return (int)(jamParkir + 1) * 2000;  // Biaya parkir motor per jam
        } else if (jenis.equals("Bus")) {
            return (int)(jamParkir + 1) * 5000;  // Biaya parkir bus per jam
        } else {
            return 0;
        }
  }
}
