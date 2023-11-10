public class Biaya {
  private Kendaraan kendaraan;
  private int jamParkir;

  public Biaya (Kendaraan kendaraan, int jamParkir) {
    this.kendaraan = kendaraan;
    this.jamParkir = jamParkir;
  }
  public int hitungBiaya() {
    if (kendaraan instanceof Mobil) {
      return jamParkir * 5000;  // Biaya parkir mobil per jam
    } else if (kendaraan instanceof Motor) {
      return jamParkir * 3000;  // Biaya parkir motor per jam
    } else if (kendaraan instanceof Bus) {
      return jamParkir * 10000;  // Biaya parkir bus per jam
    } else {
      return 0;
    }
   }
}
