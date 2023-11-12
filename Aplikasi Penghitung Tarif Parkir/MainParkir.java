import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class MainParkir {
    public static void main(String[] args) {
        Parkir parkir = new Parkir();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║     PARKIR KENDARAAN FAKULTAS MIPA     ║");
        System.out.println("║        UNIVERSITAS SYIAH KUALA         ║");
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
           System.out.println("\n");
            System.out.println("╔═════════════════════════════════╗");
            System.out.println("║              STRUK PARKIR             ║");
            System.out.println("╚═════════════════════════════════╝");
            System.out.println("║ Nomor Plat\t\t: " + kendaraan.getNomorPlat() + "\t║");
            System.out.println("║ Jenis Kendaraan\t: " + kendaraan.getJenis() + "\t\t║");
            System.out.println("║ Waktu Masuk\t\t: " + waktuMasukKembali + "\t\t║");
            System.out.println("║ Waktu Keluar\t\t: " + waktuKeluar + "\t\t║");
            System.out.println("║ Biaya Parkir\t\t: Rp " + biaya + "\t║");
        } else {
            System.out.println("Kendaraan tidak ditemukan dalam daftar parkir.");
        }

        System.out.println("║-------------------------------------\t║");
        System.out.println("║   TERIMA KASIH ATAS KUNJUNGAN ANDA  \t║");
        System.out.println("╚═════════════════════════════════╝");

        scanner.close();
    }
}
