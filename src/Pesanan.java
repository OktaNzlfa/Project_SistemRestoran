import java.util.ArrayList;
import java.util.List;

class Pesanan {
    private Pelanggan pelanggan;
    private List<Menu> items;
    private String tipePesanan; // Dine-In or Take-Away
    private double totalHarga;

    public Pesanan(Pelanggan pelanggan, String tipePesanan) {
        this.pelanggan = pelanggan;
        this.tipePesanan = tipePesanan;
        this.items = new ArrayList<>();
    }

    public void tambahItem(Menu item) {
        items.add(item);
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void hitungTotal() {
        totalHarga = 0;
        for (Menu item : items) {
            totalHarga += item.getHarga();
        }
    }

    public void cetakDetailPesanan() {
        System.out.println(" Nama Pelanggan : " + pelanggan.getNama());
        System.out.println("Tipe Pesanan : " + tipePesanan);
        System.out.println("Berapa Pesanan : ");
        for (Menu item : items) {
            System.out.println("- " + item.getNama() + ": Rp" + item.getHarga());
        }
        System.out.println("Total Harga: Rp" + totalHarga);
    }

}

