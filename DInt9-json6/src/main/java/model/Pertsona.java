/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 2AM3-3
 */
public class Pertsona {
    public String izena;
    public String abizena;
    public int adina;

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public Pertsona(String izena, String abizena, int adina) {
        this.izena = izena;
        this.abizena = abizena;
        this.adina = adina;
    }

    @Override
    public String toString() {
        return "Pertsona{" + "izena=" + izena + ", abizena=" + abizena + ", adina=" + adina + '}';
    }
    
    
    
}
