// Kelas Parkir
import java.util.Map;
import java.util.HashMap;
import java.time.LocalTime;

public class Parkir {
  private Map<Kendaraan, LocalTime> kendaraanParkir = new HashMap<>();

    public void masuk(Kendaraan kendaraan, LocalTime waktuMasuk) {
        kendaraanParkir.put(kendaraan, waktuMasuk);
    }

    public LocalTime keluar(Kendaraan kendaraan, LocalTime waktuKeluar) {
        LocalTime waktuMasuk = kendaraanParkir.get(kendaraan);
        if (waktuMasuk != null) {
            kendaraanParkir.remove(kendaraan);
            return waktuMasuk;
        } else {
            return null;
        }
    }
}
