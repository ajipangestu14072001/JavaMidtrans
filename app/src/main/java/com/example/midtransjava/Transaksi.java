package com.example.midtransjava;

public class Transaksi {
    private String idBarang;
    private int idUser;
    private int jumlahBarang;
    private String pengiriman;
    private String status;
    private int totalHarga;
    private String typePembayaran;

    public Transaksi(String idBarang, int idUser, int jumlahBarang, String pengiriman, String status, int totalHarga, String typePembayaran) {
        this.idBarang = idBarang;
        this.idUser = idUser;
        this.jumlahBarang = jumlahBarang;
        this.pengiriman = pengiriman;
        this.status = status;
        this.totalHarga = totalHarga;
        this.typePembayaran = typePembayaran;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getPengiriman() {
        return pengiriman;
    }

    public void setPengiriman(String pengiriman) {
        this.pengiriman = pengiriman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTypePembayaran() {
        return typePembayaran;
    }

    public void setTypePembayaran(String typePembayaran) {
        this.typePembayaran = typePembayaran;
    }
}
