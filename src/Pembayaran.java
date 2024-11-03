import java.util.Scanner;

class Pembayaran {
    private double jumlah;
    private String metodePembayaran; 
    private boolean statusPembayaran; // true jika berhasil, false jika gagal

    // Constructor
    public Pembayaran(double jumlah, String metodePembayaran) {
        this.jumlah = jumlah;
        this.metodePembayaran = metodePembayaran;
        this.statusPembayaran = false; // Default status pembayaran adalah gagal
    }

    // Setter dan Getter
    public double getJumlah() {
        return jumlah;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public boolean isStatusPembayaran() {
        return statusPembayaran;
    }

    // Metode untuk memproses pembayaran
    public void prosesPembayaran(double total) {
        // Logika pemrosesan pembayaran
        if (jumlah >= total) {
            statusPembayaran = true; // Simulasikan pembayaran berhasil
            System.out.println("Pembayaran sebesar Rp" + jumlah + " dengan metode " + metodePembayaran + " berhasil.");
        } else {
            System.out.println("Pembayaran gagal. Jumlah tidak cukup. Total yang harus dibayar: Rp" + total);
        }
    }

    // Metode untuk mencetak detail pembayaran
    public void printDetailPembayaran() {
        System.out.println("Detail Pembayaran:");
        System.out.println("Jumlah: Rp" + jumlah);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Status Pembayaran: " + (statusPembayaran ? "Berhasil" : "Gagal"));
    }

    // Metode untuk mendapatkan input dari pengguna
    public static Pembayaran inputPembayaran() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan metode pembayaran (Cash/Card/Transfer): ");
        String metode = scanner.nextLine();

        System.out.print("Masukkan jumlah pembayaran: Rp");
        double jumlah = scanner.nextDouble();

        return new Pembayaran(jumlah, metode);
    }
}
