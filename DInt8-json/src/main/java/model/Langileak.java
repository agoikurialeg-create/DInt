/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 2AM3-3
 */
public class Langileak {
    public int Id;
    public String Izena;
    public String Enpresa;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getIzena() {
        return Izena;
    }

    public void setIzena(String Izena) {
        this.Izena = Izena;
    }

    public String getEnpresa() {
        return Enpresa;
    }

    public void setEnpresa(String Enpresa) {
        this.Enpresa = Enpresa;
    }

    public Langileak(int Id, String Izena, String Enpresa) {
        this.Id = Id;
        this.Izena = Izena;
        this.Enpresa = Enpresa;
    }

    @Override
    public String toString() {
        return getIzena() + " (" + getEnpresa() + ")";
    }
    
    
}
