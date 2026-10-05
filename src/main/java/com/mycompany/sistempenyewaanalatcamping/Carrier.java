/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempenyewaanalatcamping;

/**
 *
 * @author sefir
 */
public class Carrier extends AlatCamping {
    private int kapasitasLiter;
    
    public Carrier(String kodeAlat, String namaAlat, double hargaSewa, int stok, int kapasitasLiter){
        super(kodeAlat, namaAlat, hargaSewa, stok);
        this.kapasitasLiter = kapasitasLiter;
    }
    public int getKapasitasLiter(){
        return this.kapasitasLiter;
    }
    public void setKapasitasLiter(int kapasitasLiter){
        if (kapasitasLiter > 0) {
            this.kapasitasLiter = kapasitasLiter;
        } else {
            System.out.println("Kapasitas carrier harus lebih dari 0.");
        }
    }
    
    @Override
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Kapasitas Carrier: " + this.kapasitasLiter + " liter");
    }
}
