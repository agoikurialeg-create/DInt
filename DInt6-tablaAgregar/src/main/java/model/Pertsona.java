/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author 2AM3-3
 */
public class Pertsona {
    public String Izena;
    public String Abizena;
    public int Adina;

    public Pertsona(String Izena, String Abizena, int Adina) {
        this.Izena = Izena;
        this.Abizena = Abizena;
        this.Adina = Adina;
    }

    public String getIzena() {
        return Izena;
    }

    public String getAbizena() {
        return Abizena;
    }

    public int getAdina() {
        return Adina;
    }

    public void setIzena(String Izena) {
        this.Izena = Izena;
    }

    public void setAbizena(String Abizena) {
        this.Abizena = Abizena;
    }

    public void setAdina(int Adina) {
        this.Adina = Adina;
    }

    @Override
    public String toString() {
        return "Pertsona{" + "Izena=" + Izena + ", Abizena=" + Abizena + ", Adina=" + Adina + '}';
    }
    
    
}
