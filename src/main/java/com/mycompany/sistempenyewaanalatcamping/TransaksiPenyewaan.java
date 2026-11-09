/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */
public class TransaksiPenyewaan {

    public void prosesSewa(
            Pelanggan pelanggan,
            AlatCamping alat) {

        System.out.println("\n=== PROSES TRANSAKSI PENYEWAAN ===");

        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan!");
            return;
        }
        if (alat == null) {
            System.out.println("Alat tidak ditemukan!");
            return;
        }
        System.out.println("ID Pelanggan : "
                + pelanggan.getIdPelanggan());
        System.out.println("Nama         : "
                + pelanggan.getNama());
        System.out.println("Kode Alat    : "
                + alat.getKodeAlat());
        System.out.println("Nama Alat    : "
                + alat.getNamaAlat());
        System.out.println("Harga Sewa   : Rp"
                + alat.getHargaSewa());

        if (alat.getStok() <= 0) {
            System.out.println("Transaksi gagal. Stok alat habis!");
            return;
        }
        alat.sewa();

        System.out.println("Status       : Transaksi berhasil!");
        System.out.println("Sisa Stok    : " + alat.getStok());
    }
}

