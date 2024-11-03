class Makanan extends Menu{
    public Makanan(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public void Tipe() {
        System.out.println(getNama() + " Makanan");
    }
}
