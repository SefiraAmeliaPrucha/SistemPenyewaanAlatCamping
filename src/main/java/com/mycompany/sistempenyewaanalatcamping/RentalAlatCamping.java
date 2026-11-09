/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentalAlatCamping {

    private Gudang gudang;

    private ArrayList<AlatCamping> daftarAlat;
    private HashMap<String, Pelanggan> daftarPelanggan;

    public RentalAlatCamping() {

        // Composition
        gudang = new Gudang(
                "Gudang Camping Utama",
                "Bandar Lampung",
                100
        );

        // Aggregation
        daftarAlat = new ArrayList<>();
        daftarPelanggan = new HashMap<>();
    }

    public void tampilkanInfoKomponen() {
        gudang.tampilkanInfoGudang();
    }

    // Menambahkan objek ke ArrayList
    public void tambahAlat(AlatCamping alat) {
        daftarAlat.add(alat);
    }

    public ArrayList<AlatCamping> getDaftarAlat() {
        return daftarAlat;
    }

    public AlatCamping cariAlat(String kode) {

        for (AlatCamping alat : daftarAlat) {
            if (alat.getKodeAlat().equalsIgnoreCase(kode)) {
                return alat;
            }
        }

        return null;
    }

    // Menambahkan objek pelanggan ke HashMap
    public void tambahPelanggan(Pelanggan pelanggan) {
        daftarPelanggan.put(
                pelanggan.getIdPelanggan(),
                pelanggan
        );
    }

    public Pelanggan cariPelanggan(String id) {
        return daftarPelanggan.get(id);
    }

    public void tampilkanSemuaPelanggan() {

        System.out.println("\n=== DAFTAR PELANGGAN ===");

        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }

        for (Map.Entry<String, Pelanggan> data
                : daftarPelanggan.entrySet()) {

            data.getValue().tampilkanInfo();
            System.out.println("----------------------");
        }

        System.out.println("Jumlah pelanggan: "
                + daftarPelanggan.size());
    }
}
