/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Complementos;
import Modelo.Convinacion;
import javax.swing.JLabel;

/**
 *
 * @author DroKaN
 */
public class Mover extends Thread {
    Convinacion movimientos;
    JLabel lbTorre;
    
    public Mover(JLabel lnTorre, Convinacion movimientos){
        this.lbTorre = lnTorre;
        this.movimientos = movimientos;
    }
    
    public void run() {
        int n = movimientos.getTamanio();
        for(int m = 0 ; m < n ;m++ )
        {
           String movimiento = movimientos.getPalabra(m).getPalabra();
            mover(movimiento);
        }
    }
    //mueve la torre deacuerdo al tipo de movimiento que se le pida
    private void mover(String obs){
       for(int i = 0 ; i < 72 ; i++){
            switch(obs){
                case "arriba": moverArriba();
                     break;
                case "abajo": moverAbajo();
                     break;
                case "izquierda": moverIz();
                     break;
                case "derecha": moverDer();
                     break;
                default:
            }
            Complementos.dormir(25);
       }
    }
    private void moverArriba()
    {
        nuevaPosicion(getX(), getY()-1);
    }
    
    private void moverAbajo()
    {
         nuevaPosicion(getX(), getY()+1);
    }
    
    private void moverIz()
    {
         nuevaPosicion(getX()-1, getY());
    }
    
    private void moverDer()
    {
         nuevaPosicion(getX()+1, getY());
    }
    
    private int getX(){
        return lbTorre.getX();
    }
    
    private int getY(){
        return lbTorre.getY();
    }
    
    private void nuevaPosicion(int x,int y){
        if(y<=650 && y>= 2 && x>=2 && x<=650)
            lbTorre.setLocation(x, y);
    }
    
    
}
