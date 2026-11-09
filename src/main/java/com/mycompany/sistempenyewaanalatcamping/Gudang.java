/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */

public class Gudang {

    private String namaGudang;
    private String lokasi;
    private int kapasitas;

    public Gudang(String namaGudang, String lokasi, int kapasitas) {
        this.namaGudang = namaGudang;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
    }

    public void tampilkanInfoGudang() {
        System.out.println("=== INFORMASI GUDANG ===");
        System.out.println("Nama Gudang : " + namaGudang);
        System.out.println("Lokasi      : " + lokasi);
        System.out.println("Kapasitas   : " + kapasitas + " alat");
    }
}

