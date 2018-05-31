/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author DroKaN
 */
public class Convinacion {
    ArrayList<Palabra> convinacion;
    
    public int getTamanio(){
        return convinacion.size();
    }
    public Convinacion(){
        convinacion = new ArrayList<>();
    }
    public ArrayList<Palabra> getConvinacion(){
       return convinacion;
    }
    
    public ArrayList<Double> getMuestra(){
        ArrayList<Double> res = new ArrayList<>();
        for(Palabra p : convinacion){
            res.addAll(p.getMuestra());
        }
        return res;
    }
    
    public Palabra getPalabra(int i){
        return convinacion.get(i);
    }
    public void addPalabra(Palabra p){
        convinacion.add(p);
    }
    public String getConvinacionT(){
        String res = "";
        for(Palabra c : convinacion){
            res += c.getPalabra()+" ";
        }
        return res;
    }
}

