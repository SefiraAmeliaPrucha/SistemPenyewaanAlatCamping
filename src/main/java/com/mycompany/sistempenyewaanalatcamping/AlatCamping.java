/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */
public class AlatCamping {
    private String kodeAlat;
    private String namaAlat;
    private double hargaSewa;
    private int stok;
    
    private static int totalAlat = 0;
    
    public AlatCamping(String kodeAlat, String namaAlat, double hargaSewa, int stok){
        this.kodeAlat = kodeAlat;
        this.namaAlat = namaAlat;
        this.hargaSewa = hargaSewa;
        this.stok = stok;
        
        totalAlat++;
    }
    
    public String getKodeAlat(){
        return this.kodeAlat;
    }
    
    public String getNamaAlat(){
        return this.namaAlat;
    }
    
    public double getHargaSewa(){
        return this.hargaSewa;
    }
    
    public int getStok(){
        return this.stok;
    }
    
    public void setKodeAlat(String KodeAlat){
        this.kodeAlat = kodeAlat;
    }
    
    public void setHargaSewa(double hargaSewa){
        if (hargaSewa > 0) {
            this.hargaSewa = hargaSewa;
        }else{
            System.out.println("Harga sewa harus lebih dari 0.");
        }
    }
    
    public void setStok(int stok){
        if (stok >= 0) {
            this.stok = stok;
        }else{
            System.out.println("Stok tiidak boleh negatif.");
        }
    }
    
    
   
    
    public static int getTotalAlat(){
        return totalAlat;
    }
    
    public void tampilkanInfo(){
        System.out.printf("Kode: %-8s | Nama: %20s | Harga Sewa: Rp%.0f | Stok: %d%n", this.kodeAlat, this.namaAlat, this.hargaSewa, this.stok);
    }
    
    public void sewa(){
        if(this.stok > 0){
            this.stok--;
            System.out.println("Alat berhasil disewa.");
            System.out.println("Sisa stok: " + this.stok);   
        }else{
            System.out.println("Maaf, stok alat sedang habis.");
        }
    }
    
}
