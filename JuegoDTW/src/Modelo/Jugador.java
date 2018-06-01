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
    
    public void realizarMovimientos(ArrayList<String> movimientos){
        new MoverJugador(movimientos).start();
    }
    
    private int getAncho(){
        return personaje.getWidth();
    }
    
    private int getLargo(){
        return personaje.getHeight();
    }
    
    public void mostrarPersonaje(){
        Complementos.nuevoIcono(fotograma+".png", personaje, true);
    }
    
    //hilo para animar los movimientos del personaje
    public class MoverJugador extends Thread{
    private ArrayList<String> movimientos;
    
    public MoverJugador(ArrayList<String> movimientos){
        this.movimientos = movimientos;
    }
    
    
    
    public void run(){
        for(String movimiento : movimientos){
            if(movimiento.equals("izquierda")|| movimiento.equals("derecha" )){
                for(int n = 0 ; n < getAncho() ;n++){
                    moverse(movimiento);
                    Complementos.dormir(40);
                }
            }else{
                for(int n = 0 ; n < getLargo() ;n++){
                    moverse(movimiento);
                    Complementos.dormir(40);
                }
            }     
        }
    }
    
    private void moverse(String movimiento){
        switch(movimiento){
            case "izquierda" : caminarIzquierda();
                break;
            case "derecha"   : caminarDerecha();
                break;
            case "arriba"    : caminarArriba();
                break;
            case "abajo"     : caminarAbajo();
                break;
            
        }
    }
    
    private void caminarIzquierda(){
        posX =posX -1;
        modificarPosicion(-1,0);
         
    }
    
    private void caminarDerecha(){
        posX =posX -1;
        modificarPosicion(1,0);
    }
      
    private void caminarArriba(){
        posY =posY +1;
        modificarPosicion(0,-1);
    }
      
    private void caminarAbajo(){
        posY =posY -1;
        modificarPosicion(0,1);
    }
    
    private void modificarPosicion(int x,int y){
        fotograma =  fotograma + 1;
        personaje.setLocation(personaje.getX()+x, personaje.getY()+y);
        mostrarPersonaje();
        if(fotograma == 28)
            fotograma = -1;
    }      
}
}
