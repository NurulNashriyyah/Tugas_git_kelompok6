import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Biaya {
    private Kendaraan kendaraan;
    private long menitParkir;

    public Biaya(Kendaraan kendaraan, LocalTime waktuMasuk, LocalTime waktuKeluar) {
        this.kendaraan = kendaraan;

        if (waktuKeluar.isBefore(waktuMasuk)) {
            // Kendaraan keluar pada hari berikutnya
            Duration durasiHariIni = Duration.between(waktuMasuk, LocalTime.of(23, 59));
            Duration durasiHariBesok = Duration.between(LocalTime.of(0, 0), waktuKeluar);
            this.menitParkir = durasiHariIni.toMinutes() + durasiHariBesok.toMinutes();
        } else {
            // Kendaraan keluar pada hari yang sama
            Duration durasi = Duration.between(waktuMasuk, waktuKeluar);
            this.menitParkir = durasi.toMinutes();
        }
    }

    public int hitungBiaya() {
        String jenis = kendaraan.getJenis();
        int biayaPerJam = 0; // Biaya parkir per jam
        int menitPerJam = 60; // Menit dalam satu jam

        if (jenis.equals("Mobil")) {
            biayaPerJam = 3000; // Biaya parkir mobil per jam
        } else if (jenis.equals("Motor")) {
            biayaPerJam = 2000; // Biaya parkir motor per jam
        } else if (jenis.equals("Bus")) {
            biayaPerJam = 5000; // Biaya parkir bus per jam
        } else {
            return 0;
        }

        int biaya = 0;

        if (menitParkir <= menitPerJam) {
            // Kendaraan parkir kurang dari satu jam
            biaya = biayaPerJam;
        } else {
            // Kendaraan parkir lebih dari satu jam
            double jamPenuh = Math.ceil((double) menitParkir / menitPerJam);
            biaya = (int) jamPenuh * biayaPerJam;
        }

        return biaya;
    }
}
