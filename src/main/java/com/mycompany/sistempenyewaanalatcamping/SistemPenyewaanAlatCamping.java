/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */
import java.util.Scanner;
public class SistemPenyewaanAlatCamping {
    public static void cariAlat(String nama, AlatCamping[] daftarAlat, int jumlahAlat){
        boolean ditemukan = false;
        
        System.out.println();
        System.out.println(" --------------------------------------------");
        System.out.println("|            HASIL PENCARIAN NAMA            |");
        System.out.println(" --------------------------------------------");
    
        for (int i = 0; i < jumlahAlat; i++){
            if(daftarAlat[i].getNamaAlat().equalsIgnoreCase(nama)){
                System.out.println();
                System.out.println("Alat berhasil ditemukan!");
                System.out.println("-----------------------------------------------");
                
                daftarAlat[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if(!ditemukan){
            System.out.println();
            System.out.println("alat dengan nama " + nama + "tidak ditemuka.");
        }
    }
    
    public static void cariAlat(double hargaMaksimal, AlatCamping[] daftarAlat, int jumlahAlat){
        boolean ditemukan = false;
        
        
        System.out.println();
        System.out.println(" -----------------------------------------------");
        System.out.println("|             HASIL PENCARIAN HARGA             |");
        System.out.println(" -----------------------------------------------");
        
        for(int i = 0; i < jumlahAlat; i++){
            if (daftarAlat[i].getHargaSewa() <= hargaMaksimal){
                System.out.println();
                System.out.println("Alat ditemukan!.");
                System.out.println("-----------------------------------------------");
                
                daftarAlat[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if(!ditemukan){
            System.out.println();
            System.out.printf("Tidak ada alat dengan harga sewa maksimal Rp%.0f.%n", hargaMaksimal);
        }
    }
    
    public static void prosesPenyewaan(AlatCamping alat){
        System.out.println();
        System.out.println(" -----------------------------------------------------");
        System.out.println("|                   PROSES PENYEWAAN                  |");
        System.out.println(" -----------------------------------------------------");
        System.out.println("Alat yang dipilih:");
        alat.tampilkanInfo();
        
        System.out.println();
        alat.sewa();  
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AlatCamping[] daftarAlat = new AlatCamping[10];

        int jumlahAlat = 0;
        boolean berjalan = true;


        System.out.println();
        System.out.println(" =====================================================");
        System.out.println("||                                                    ||");
        System.out.println("||             SISTEM PENYEWAAN ALAT CAMPING          ||");
        System.out.println("||                                                    ||");
        System.out.println(" =====================================================");

        while (berjalan){
            System.out.println();
            System.out.println(" -----------------------------------------------------");
            System.out.println("|                     MENU UTAMA                      |");
            System.out.println(" -----------------------------------------------------");
            System.out.println("|  1. Tambah Alat                                     |");
            System.out.println("|  2. Tampilan Seluruh Alat                           |");
            System.out.println("|  3. Pencarian Khusus                                |");
            System.out.println("|  4. Simulasi Penyewaan                              |");
            System.out.println("|  5. Keluar                                          |");
            System.out.println(" -----------------------------------------------------");

            System.out.print(" Pilih menu [1-5]: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan){

                case 1:
                    if (jumlahAlat < daftarAlat.length){
                        System.out.println();
                        System.out.println(" -----------------------------------------------------");
                        System.out.println("|                     TAMBAH ALAT                     |");
                        System.out.println(" -----------------------------------------------------");
                 
                        System.out.println(" Pilih Jenis Alat: ");
                        System.out.println(" -----------------------------------------------------");
                        System.out.println("|  1. Tenda                                           |");
                        System.out.println("|  2. Kompor                                          |");
                        System.out.println("|  3. Carrier                                          |");
                        System.out.println("|  4. Matras                                          |");
                        System.out.println(" -----------------------------------------------------");

                        System.out.print(" Pilihan: ");
                        int jenisAlat = scanner.nextInt();
                        scanner.nextLine();

                        if(jenisAlat >= 1 && jenisAlat <= 4){
                            System.out.println();
                            System.out.println("-------------------DATA UMUM ALAT----------------");
                            System.out.print(" Kode Alat            : ");
                            String kode = scanner.nextLine();
                            System.out.print(" Nama Alat            : ");
                            String nama = scanner.nextLine();
                            System.out.print(" Harga Sewa           : Rp");
                            double harga = scanner.nextDouble();
                            System.out.print(" Stok                 : ");
                            int stok = scanner.nextInt();
                            scanner.nextLine();

                            if(jenisAlat == 1){
                                System.out.println();
                                System.out.println("----------------- DATA TENDA --------------------");
                                System.out.print(" Kapasitas Tenda            : ");

                                int kapasitas = scanner.nextInt();
                                scanner.nextLine();

                                Tenda tendaBaru = new Tenda(kode, nama, harga, stok, kapasitas);

                                daftarAlat[jumlahAlat] = tendaBaru;
                                jumlahAlat++;

                                System.out.println();
                                System.out.println("Tenda berhasil ditambahkan!");
                            }else if (jenisAlat == 2){
                                System.out.println();
                                System.out.println("---------------- DATA KOMPOR --------------------");
                                System.out.print(" Jenis Bahan Bakar          : ");

                                String bahanBakar = scanner.nextLine();
                                Kompor komporBaru = new Kompor(kode, nama, harga, stok, bahanBakar);

                                daftarAlat[jumlahAlat] = komporBaru;
                                jumlahAlat++;

                                System.out.println();
                                System.out.println("Kompor berhasil ditambahkan!");
                            }else if (jenisAlat == 3) {
                                System.out.println();
                                System.out.println("--------------- DATA CARRIER --------------------");
                                System.out.print(" Kapasitas Carrier        : ");
                                
                                int kapasitasLiter = scanner.nextInt();
                                scanner.nextLine();
                                
                                Carrier carrierBaru = new Carrier(kode, nama, harga, stok, kapasitasLiter);
                                
                                daftarAlat[jumlahAlat] = carrierBaru;
                                jumlahAlat++;
                                
                                System.out.println();
                                System.out.println("Carrier berhasil ditambahkan!");
                            }else{
                                System.out.println();
                                System.out.println("---------------- DATA MATRAS --------------------");
                                System.out.print(" Jenis Matras             : ");

                                String jenisMatras = scanner.nextLine();
                                Matras matrasBaru = new Matras(kode, nama, harga, stok, jenisMatras);

                                daftarAlat[jumlahAlat] = matrasBaru;
                                jumlahAlat++;

                                System.out.println();
                                System.out.println("Matras berhasil ditambahkan!");
                            }

                        } else{
                            System.out.println();
                            System.out.println(" Jenis alat tidak valid!");
                        }
                    }else{
                        System.out.println();
                        System.out.println(" Penyimpanan alat sudah penuh!");
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println(" -----------------------------------------------------");
                    System.out.println("|                  DAFTAR ALAT CAMPING                |");
                    System.out.println(" -----------------------------------------------------");

                    if (jumlahAlat == 0){
                        System.out.println();
                        System.out.println(" Belum ada data alat yang tersimpan.");
                    }else{
                        for(int i = 0; i < jumlahAlat; i++){
                            System.out.println();
                            System.out.println("=============== DATA KE-" + (i+1)+ "==================");
                            daftarAlat[i].tampilkanInfo();
                            System.out.println("------------------------------------------------------");
                        }
                        System.out.println();
                        System.out.print(" Total alat terdaftar: " + AlatCamping.getTotalAlat());
                    }
                    System.out.println();
                    System.out.println(" Tekan ENTER untuk kembali ke menu...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println();
                    System.out.println(" -----------------------------------------------------");
                    System.out.println("|                    PENCARIAN KHUSUS                  |");
                    System.out.println(" -----------------------------------------------------");

                    System.out.println();
                    System.out.println(" 1. Cari berdasarkan Nama");
                    System.out.println(" 2. Cari berdasarkan Harga");

                    System.out.println("\n Pilih aksi [1-2] : ");
                    int pilihanAksi = scanner.nextInt();
                    scanner.nextLine();

                    if(pilihanAksi == 1){
                        System.out.print("\n Masukkan nama alat : ");
                        String namaCari = scanner.nextLine();   
                        cariAlat(namaCari, daftarAlat, jumlahAlat);
                    }else if (pilihanAksi == 2){
                        System.out.print("\n Masukkan harga maksimal : Rp");
                        double hargaCari = scanner.nextDouble();
                        scanner.nextLine();
                        cariAlat(hargaCari, daftarAlat, jumlahAlat);
                    
                    }else{
                        System.out.println();
                        System.out.println(" Pilihan tidak valid!");
                    }
                    System.out.println();
                    System.out.println(" Tekan ENTER untuk kembali ke menu...");
                    scanner.nextLine();
                    break;
                
                case 4:
                    System.out.println();
                    System.out.println(" -----------------------------------------------------");
                    System.out.println("|                  SIMULASI PENYEWAAN                 |");
                    System.out.println(" -----------------------------------------------------");
                    System.out.println(" Masukkan kode alat            : ");
                    String kodeSewa = scanner.nextLine();
                    
                    boolean ditemukan = false;
                    
                    for (int i = 0; i < jumlahAlat; i++){
                        if (daftarAlat[i].getKodeAlat().equalsIgnoreCase(kodeSewa)){
                            prosesPenyewaan(daftarAlat[i]);
                            
                            ditemukan = true;
                            break;
                        }
                    }
                    
                    if (!ditemukan){
                        System.out.println();
                        System.out.println(" Kode alat tidak ditemukan.");
                    }
                    System.out.println();
                    System.out.println(" Tekan ENTER untuk kembali ke menu...");
                    scanner.nextLine();
                    break;

                case 5:
                    System.out.println();
                    System.out.println(" =====================================================");
                    System.out.println("||                                                    ||");
                    System.out.println("||           TERIMA KASIH TELAH MENGGUNAKAN           ||");
                    System.out.println("||            SISTEM PENYEWAAN ALAT CAMPING           ||");
                    System.out.println("||                                                    ||");
                    System.out.println(" =====================================================");

                    berjalan = false;
                    break;

                default:
                    System.out.println();
                    System.out.println(" Pilihan tidak valid!");
                    System.out.println(" Silakan masukkan angka 1 sampai 5");



            }
        }
        scanner.close();

    }
}
