import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class MainParkir {
    public static void main(String[] args) {
        Parkir parkir = new Parkir();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║  PARKIR KENDARAAN FAKULTAS MIPA  ║");
        System.out.println("║     UNIVERSITAS SYIAH KUALA      ║");
        System.out.println("╚══════════════════════════════════╝");

        System.out.print("Masukkan nomor plat kendaraan: ");
        String nomorPlat = scanner.nextLine();

        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.println("3. Bus");
        System.out.print("Masukkan angka (1/2/3): ");
        int jenisKendaraan = scanner.nextInt();

        Kendaraan kendaraan = null;
        switch (jenisKendaraan) {
            case 1:
                kendaraan = new Mobil(nomorPlat);
                break;
            case 2:
                kendaraan = new Motor(nomorPlat);
                break;
            case 3:
                kendaraan = new Bus(nomorPlat);
                break;
            default:
                System.out.println("Jenis kendaraan tidak valid.");
                return;
        }

         System.out.print("Masukkan waktu masuk (HH:mm): ");
        String waktuMasukStr = scanner.next();
        LocalTime waktuMasuk = LocalTime.parse(waktuMasukStr);
        parkir.masuk(kendaraan, waktuMasuk);

        System.out.print("Masukkan waktu keluar (HH:mm): ");
        String waktuKeluarStr = scanner.next();
        LocalTime waktuKeluar = LocalTime.parse(waktuKeluarStr);
        LocalTime waktuMasukKembali = parkir.keluar(kendaraan, waktuKeluar);

        
        
        
        
        if (waktuMasukKembali != null) {
            int biaya = new Biaya(kendaraan, waktuMasukKembali, waktuKeluar).hitungBiaya();
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║          STRUK PARKIR            ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("Nomor Plat: " + kendaraan.getNomorPlat());
            System.out.println("Jenis Kendaraan: " + kendaraan.getJenis());
            System.out.println("Waktu Masuk: " + waktuMasukKembali);
            System.out.println("Waktu Keluar: " + waktuKeluar);
            System.out.println("Biaya Parkir: Rp " + biaya);
        } else {
            System.out.println("Kendaraan tidak ditemukan dalam daftar parkir.");
        }

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║ TERIMA KASIH ATAS KUNJUNGAN ANDA ║");
        System.out.println("╚══════════════════════════════════╝");

        scanner.close();
    }
}
