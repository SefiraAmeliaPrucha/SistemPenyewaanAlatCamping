/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */
public class Tenda extends AlatCamping {
    private int kapasitas;
    public Tenda(String kodeAlat, String namaAlat, double hargaSewa, int stok, int kapasitas){
        super(kodeAlat, namaAlat, hargaSewa, stok);
        this.kapasitas = kapasitas;
    }
    
    public int getKapasitas(){
        return this.kapasitas;
    }
    
    public void setKapasitas(int kapasitas){
        if (kapasitas > 0){
            this.kapasitas = kapasitas;
        }else{
            System.out.println("Kapasitas tenda harus ada");
        }
    }
    
    @Override
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Kapasitas Tenda: " + this.kapasitas + "orang");
    }  
}
