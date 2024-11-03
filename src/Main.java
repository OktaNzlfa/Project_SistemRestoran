import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Menu> menuList = new ArrayList<>();
    public static void main(String[] args) {
        initializeMenu();
        Scanner scanner = new Scanner(System.in);
        Pelanggan pelanggan = null;
        Pesanan pesanan = null;
       // Menu menu = new Menu("juki", 43000); // Inisialisasi menu

        while (true) {
            System.out.println("=== Sistem Manajemen Restoran ===");
            System.out.println("1. Masukkan Nama Pelanggan");
            System.out.println("2. Buat Pesanan");
            System.out.println("3. Lakukan Pembayaran");
            System.out.println("4. Lihat Detail Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon pelanggan: ");
                    String telepon = scanner.nextLine();
                    pelanggan = new Pelanggan(nama, telepon);
                    System.out.println("Pelanggan " + nama + " telah terdaftar.");
                    break;

                case 2:
                    if (pelanggan == null) {
                        System.out.println("Silakan masukkan nama pelanggan terlebih dahulu.");
                    } else {
                        pesanan = new Pesanan(pelanggan, "Dine-In");
                        System.out.println("Pesanan untuk " + pelanggan.getNama() + " telah dibuat.");
                        System.out.println("Pilih item dari menu (masukkan nomor menu): ");
                    
                        // Display the menu
                        tampilkanMenu();

                        System.out.print("Masukkan nomor menu yang ingin diambil: ");
                        int nomor = scanner.nextInt();
                        if (nomor > 0 && nomor <= menuList.size()) {
                            Menu selectedMenu = menuList.get(nomor - 1);
                            pesanan.tambahItem(selectedMenu); // Add selected menu item to the order
                            System.out.println("Anda memilih: " + selectedMenu.getNama());
                        } else {
                            System.out.println("Nomor menu tidak valid.");
                        }

                        pesanan.hitungTotal();
                        System.out.println("Total harga pesanan: Rp" + pesanan.getTotalHarga());
                    }
                    break;

                case 3:
                    if (pesanan != null) {
                        Pembayaran payment = Pembayaran.inputPembayaran();
                        payment.prosesPembayaran(pesanan.getTotalHarga());
                        payment.printDetailPembayaran();
                    } else {
                        System.out.println("Belum ada pesanan.");
                    }
                    break;

                case 4:
                    if (pesanan != null) {
                        pesanan.cetakDetailPesanan();
                    } else {
                        System.out.println("Belum ada pesanan.");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem kami!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println(); // Baris kosong untuk pemisah
        }
    }

    private static void initializeMenu() {
        menuList.add(new Menu("Nasi Goreng", 15000));
        menuList.add(new Menu("Soto", 12000));
        menuList.add(new Menu("Bakso", 10000));
        menuList.add(new Menu("Mie Ayam", 13000));
        menuList.add(new Menu("Nasi Putih", 8000));
    }

    private static void tampilkanMenu() {
        System.out.println("=== Menu ===");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getNama() + " Rp." + menuList.get(i).getHarga());
        }
    }
}
