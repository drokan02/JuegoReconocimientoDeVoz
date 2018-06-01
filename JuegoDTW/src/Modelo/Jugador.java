/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author DroKaN
 */
public class Jugador {
    private String nombre;
    private int nroVidas;
    private JLabel personaje;
    private int posX;
    private int posY;
    private int fotograma;
    public Jugador(String nombre,int nroVidas){
        this.nombre = nombre;
        this.nroVidas = nroVidas;
        this.posX = 0;
        this.posX = 0;
        this.fotograma = 0;
    }
    
    public void mostrarPersonaje(JFrame ventana,int ancho,int largo){
        personaje = new JLabel();
        personaje.setBounds(posX, posY, ancho, largo);
        mostrarPersonaje();
        ventana.add(personaje);
    }
    
    public int getVidas(){
        return nroVidas;
    }
    
    public void setVidas(int n){
        nroVidas = nroVidas + n;
    }
    public int getAncho(){
        return personaje.getWidth();
    }
    
    public int getLargo(){
        return personaje.getHeight();
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public void setPosX(int x){
        posX = posX+x;
    }
    
    public void setPosY(int y){
        posY = posY+y;
    }
    
    public int getFotograma(){
        return fotograma;
    }
    
    public void setFotograma(){
        fotograma =  fotograma + 1;
        if(fotograma > 28)
            fotograma = 0;
    }
    
    public void mostrarPersonaje(){
        Complementos.nuevoIcono(fotograma+".png", personaje, true);
    }
    
    public void setPosicionPersonaje(int x,int y){
        personaje.setLocation(personaje.getX()+x, personaje.getY()+y);
    }
    
}
