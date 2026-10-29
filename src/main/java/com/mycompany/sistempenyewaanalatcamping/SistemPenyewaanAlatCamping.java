/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemPenyewaanAlatCamping {

    // COLLECTION 1: menyimpan objek alat secara dinamis
    private static ArrayList<AlatCamping> daftarAlat =
            new ArrayList<>();

    // COLLECTION 2: ID pelanggan sebagai key, nama sebagai value
    private static HashMap<String, String> daftarPelanggan =
            new HashMap<>();

    // Memeriksa teks kosong dengan throw
    public static String validasiTeks(
            String teks, String namaField)
            throws DataPenyewaanException {

        if (teks == null || teks.trim().isEmpty()) {
            throw new DataPenyewaanException(
                    namaField + " tidak boleh kosong.");
        }

        return teks.trim();
    }

    public static double bacaHarga(Scanner sc)
            throws DataPenyewaanException {

        double harga = Double.parseDouble(sc.nextLine().trim());

        if (harga <= 0) {
            throw new DataPenyewaanException(
                    "Harga sewa harus lebih dari 0.");
        }

        return harga;
    }

    public static int bacaStok(Scanner sc)
            throws DataPenyewaanException {

        int stok = Integer.parseInt(sc.nextLine().trim());

        if (stok < 0) {
            throw new DataPenyewaanException(
                    "Stok tidak boleh negatif.");
        }

        return stok;
    }

    // Pencarian berdasarkan kode: pake throws
    public static AlatCamping cariAlatByKode(String kode)
            throws DataPenyewaanException {

        kode = validasiTeks(kode, "Kode alat");

        for (AlatCamping alat : daftarAlat) {
            if (alat.getKodeAlat().equalsIgnoreCase(kode)) {
                return alat;
            }
        }

        throw new DataPenyewaanException(
                "Alat dengan kode " + kode + " tidak ditemukan.");
    }

    // Pencarian berdasarkan nama
    public static void cariAlatByNama(String nama)
            throws DataPenyewaanException {

        nama = validasiTeks(nama, "Nama alat");
        boolean ditemukan = false;

        for (AlatCamping alat : daftarAlat) {
            if (alat.getNamaAlat().equalsIgnoreCase(nama)) {
                alat.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new DataPenyewaanException(
                    "Alat dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Pencarian berdasarkan harga maksimal
    public static void cariAlatByHarga(double maksimal)
            throws DataPenyewaanException {

        if (maksimal < 0) {
            throw new DataPenyewaanException(
                    "Harga maksimal tidak boleh negatif.");
        }

        boolean ditemukan = false;

        for (AlatCamping alat : daftarAlat) {
            if (alat.getHargaSewa() <= maksimal) {
                alat.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new DataPenyewaanException(
                    "Tidak ada alat dengan harga maksimal Rp"
                    + maksimal);
        }
    }

    // Menambahkan objek ke ArrayList
    public static void tambahAlat(Scanner sc)
            throws DataPenyewaanException {

        System.out.println("\n=== TAMBAH ALAT CAMPING ===");
        System.out.println("1. Tenda");
        System.out.println("2. Kompor");
        System.out.println("3. Carrier");
        System.out.println("4. Matras");
        System.out.print("Pilih jenis alat: ");

        int jenis = Integer.parseInt(sc.nextLine().trim());

        if (jenis < 1 || jenis > 4) {
            throw new DataPenyewaanException(
                    "Jenis alat harus dipilih dari 1 sampai 4.");
        }

        System.out.print("Kode alat: ");
        String kode = validasiTeks(sc.nextLine(), "Kode alat");

        // Mastiin kode alat unik
        for (AlatCamping alat : daftarAlat) {
            if (alat.getKodeAlat().equalsIgnoreCase(kode)) {
                throw new DataPenyewaanException(
                        "Kode alat sudah digunakan.");
            }
        }

        System.out.print("Nama alat: ");
        String nama = validasiTeks(sc.nextLine(), "Nama alat");

        System.out.print("Harga sewa: Rp");
        double harga = bacaHarga(sc);

        System.out.print("Stok: ");
        int stok = bacaStok(sc);

        AlatCamping alatBaru;

        switch (jenis) {
            case 1:
                System.out.print("Kapasitas tenda (orang): ");
                int kapasitas = Integer.parseInt(
                        sc.nextLine().trim());

                if (kapasitas <= 0) {
                    throw new DataPenyewaanException(
                            "Kapasitas tenda harus lebih dari 0.");
                }

                alatBaru = new Tenda(
                        kode, nama, harga, stok, kapasitas);
                break;

            case 2:
                System.out.print("Jenis bahan bakar: ");
                String bahanBakar = validasiTeks(
                        sc.nextLine(), "Jenis bahan bakar");

                alatBaru = new Kompor(
                        kode, nama, harga, stok, bahanBakar);
                break;

            case 3:
                System.out.print("Kapasitas carrier (liter): ");
                int liter = Integer.parseInt(
                        sc.nextLine().trim());

                if (liter <= 0) {
                    throw new DataPenyewaanException(
                            "Kapasitas carrier harus lebih dari 0.");
                }

                alatBaru = new Carrier(
                        kode, nama, harga, stok, liter);
                break;

            default:
                System.out.print("Jenis matras: ");
                String jenisMatras = validasiTeks(
                        sc.nextLine(), "Jenis matras");

                alatBaru = new Matras(
                        kode, nama, harga, stok, jenisMatras);
                break;
        }

        daftarAlat.add(alatBaru);

        System.out.println("Alat berhasil ditambahkan!");
        System.out.println("Jumlah alat sekarang: "
                + daftarAlat.size());
    }

    // Menampilkan seluruh objek ArrayList
    public static void tampilkanSemuaAlat() {

        System.out.println("\n=== DAFTAR ALAT CAMPING ===");

        if (daftarAlat.isEmpty()) {
            System.out.println("Belum ada alat yang tersimpan.");
            return;
        }

        for (int i = 0; i < daftarAlat.size(); i++) {
            System.out.println("\nData alat ke-" + (i + 1));
            daftarAlat.get(i).tampilkanInfo();
        }

        System.out.println("\nJumlah alat: " + daftarAlat.size());
        System.out.println("Total objek dibuat: "
                + AlatCamping.getTotalAlat());
    }

    // Menu pencarian dan penyewaan
    public static void menuPencarian(Scanner sc)
            throws DataPenyewaanException {

        System.out.println("\n=== PENCARIAN KHUSUS ===");
        System.out.println("1. Cari berdasarkan nama");
        System.out.println("2. Cari berdasarkan harga maksimal");
        System.out.println("3. Sewa alat berdasarkan kode");
        System.out.print("Pilih: ");

        int pilihan = Integer.parseInt(sc.nextLine().trim());

        switch (pilihan) {
            case 1:
                System.out.print("Nama alat: ");
                cariAlatByNama(sc.nextLine());
                break;

            case 2:
                System.out.print("Harga maksimal: Rp");
                double harga = Double.parseDouble(
                        sc.nextLine().trim());
                cariAlatByHarga(harga);
                break;

            case 3:
                System.out.print("Kode alat: ");
                String kode = sc.nextLine();

                AlatCamping alat = cariAlatByKode(kode);
                alat.tampilkanInfo();
                alat.sewa();
                break;

            default:
                throw new DataPenyewaanException(
                        "Pilihan pencarian tidak valid.");
        }
    }

    // Pengujian interface dan instanceof dari Modul 7
    public static void ujiInterface() {

        System.out.println("\n=== PENGUJIAN INTERFACE ===");

        if (daftarAlat.isEmpty()) {
            System.out.println("Belum ada data alat.");
            return;
        }

        for (AlatCamping alat : daftarAlat) {
            System.out.println("\nData alat:");
            alat.tampilkanInfo();

            if (alat instanceof DapatDisewakan) {
                DapatDisewakan sewa =
                        (DapatDisewakan) alat;
                sewa.tampilkanStatusPenyewaan();
            }

            if (alat instanceof DapatDiperiksa) {
                DapatDiperiksa periksa =
                        (DapatDiperiksa) alat;
                periksa.periksaKondisi();
            }
        }
    }

    // Menu pengelolaan HashMap
    public static void menuPelanggan(Scanner sc)
            throws DataPenyewaanException {

        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n=== DATA PELANGGAN ===");
            System.out.println("1. Tambah pelanggan");
            System.out.println("2. Cari pelanggan berdasarkan ID");
            System.out.println("3. Tampilkan semua pelanggan");
            System.out.println("4. Kembali");
            System.out.print("Pilih: ");

            int pilihan = Integer.parseInt(
                    sc.nextLine().trim());

            switch (pilihan) {
                case 1:
                    System.out.print("ID pelanggan: ");
                    String id = validasiTeks(
                            sc.nextLine(), "ID pelanggan");

                    if (daftarPelanggan.containsKey(id)) {
                        throw new DataPenyewaanException(
                                "ID pelanggan sudah terdaftar.");
                    }

                    System.out.print("Nama pelanggan: ");
                    String nama = validasiTeks(
                            sc.nextLine(), "Nama pelanggan");

                    // HashMap .put()
                    daftarPelanggan.put(id, nama);

                    System.out.println(
                            "Pelanggan berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.print("Masukkan ID pelanggan: ");
                    String cariID = validasiTeks(
                            sc.nextLine(), "ID pelanggan");

                    // HashMap .containsKey() dan .get()
                    if (daftarPelanggan.containsKey(cariID)) {
                        System.out.println("Data ditemukan.");
                        System.out.println("ID: " + cariID);
                        System.out.println("Nama: "
                                + daftarPelanggan.get(cariID));
                    } else {
                        throw new DataPenyewaanException(
                                "Pelanggan dengan ID "
                                + cariID + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    if (daftarPelanggan.isEmpty()) {
                        System.out.println(
                                "Belum ada data pelanggan.");
                    } else {
                        System.out.println(
                                "\n--- SELURUH PELANGGAN ---");

                        for (Map.Entry<String, String> data
                                : daftarPelanggan.entrySet()) {
                            System.out.println(
                                    "ID: " + data.getKey()
                                    + " | Nama: "
                                    + data.getValue());
                        }

                        System.out.println("Jumlah pelanggan: "
                                + daftarPelanggan.size());
                    }
                    break;

                case 4:
                    kembali = true;
                    break;

                default:
                    throw new DataPenyewaanException(
                            "Pilihan menu pelanggan tidak valid.");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean berjalan = true;

        // Empat objek awal untuk ArrayList
        daftarAlat.add(
                new Tenda("T001", "Tenda Dome", 50000, 5, 4));
        daftarAlat.add(
                new Kompor("K001", "Kompor Portable", 20000, 3, "Gas"));
        daftarAlat.add(
                new Carrier("C001", "Carrier Gunung", 30000, 4, 60));
        daftarAlat.add(
                new Matras("M001", "Matras Camping", 10000, 8,
                        "Aluminium"));

        // Tiga data awal untuk HashMap
        daftarPelanggan.put("P001", "Budi");
        daftarPelanggan.put("P002", "Siti");
        daftarPelanggan.put("P003", "Andi");

        System.out.println("======================================");
        System.out.println(" SISTEM PENYEWAAN ALAT CAMPING");
        System.out.println("======================================");

        while (berjalan) {
            System.out.println("\n============== MENU UTAMA ==============");
            System.out.println("1. Tambah alat");
            System.out.println("2. Tampilkan seluruh alat");
            System.out.println("3. Pencarian dan penyewaan alat");
            System.out.println("4. Pengujian interface dan instanceof");
            System.out.println("5. Kelola data pelanggan (HashMap)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu [1-6]: ");

            try {
                int pilihan = Integer.parseInt(
                        sc.nextLine().trim());

                switch (pilihan) {
                    case 1:
                        tambahAlat(sc);
                        break;

                    case 2:
                        tampilkanSemuaAlat();
                        break;

                    case 3:
                        menuPencarian(sc);
                        break;

                    case 4:
                        ujiInterface();
                        break;

                    case 5:
                        menuPelanggan(sc);
                        break;

                    case 6:
                        berjalan = false;
                        System.out.println(
                                "Terima kasih telah menggunakan program.");
                        break;

                    default:
                        throw new DataPenyewaanException(
                                "Pilihan menu harus antara 1 sampai 6.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "ERROR: Input angka tidak valid. "
                        + "Masukkan angka sesuai menu.");

            } catch (DataPenyewaanException e) {
                System.out.println(
                        "ERROR: " + e.getMessage());

            } finally {
                // Finally tetap dijalankan setelah setiap proses menu
                System.out.println(
                        "[FINALLY] Proses menu selesai.");
            }
        }

        sc.close();
        System.out.println("Scanner ditutup. Program berakhir.");
    }
}
