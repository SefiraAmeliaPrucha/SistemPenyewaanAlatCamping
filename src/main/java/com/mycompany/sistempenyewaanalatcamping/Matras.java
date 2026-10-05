/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */
public class Matras extends AlatCamping {
    private String jenisMatras;
    
    public Matras(String kodeAlat, String namaAlat, double hargaSewa, int stok, String jenisMatras){
        super(kodeAlat, namaAlat, hargaSewa, stok);
        this.jenisMatras = jenisMatras;
    }
    public String getJenisMatras(){
        return this.jenisMatras;
    }
    public void setJenisMatras(String jenisMatras){
        if (jenisMatras != null && !jenisMatras.isEmpty()){
            this.jenisMatras = jenisMatras;
        } else {
            System.out.println("Jenis matras tidak boleh kosong");
        }
    }
    @Override 
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Jenis Matras: " + this.jenisMatras);
    }
}
