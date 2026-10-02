/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */
public class Kompor extends AlatCamping{
    private String jenisBahanBakar;
    
    public Kompor(String kodeAlat, String namaAlat, double hargaSewa, int stok, String jenisBahanBakar){
        super(kodeAlat, namaAlat, hargaSewa, stok);
        this.jenisBahanBakar = jenisBahanBakar;
    }
    
    public String getJenisBahanBakar(){
        return this.jenisBahanBakar;
    }
    
    public void setJenisBahanBakar(String jenisBahanBakar){
        this.jenisBahanBakar = jenisBahanBakar;
    } 
    @Override
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Jenis Bahan Bakar: " + this.jenisBahanBakar);
    }
}


