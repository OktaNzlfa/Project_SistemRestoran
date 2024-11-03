class Minuman extends Menu{
    public Minuman(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public void Tipe() {
        System.out.println(getNama() + " Minuman");
    }
}
