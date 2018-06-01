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
public class MoverJugador extends Thread{
    Jugador jugador;
    TableroJuego tablero;
    ArrayList<String> movimientos;
    
    public MoverJugador(Jugador jugador,TableroJuego tablero, ArrayList<String> movimientos)
    {
        this.jugador = jugador;
        this.tablero = tablero;
        this.movimientos = movimientos;
    }
    
    public void run(){
        moverJugador();
    }
    
    private void moverJugador(){
        for(String movimiento : movimientos){
            
            if(movimientoValido(movimiento)){
                if(movimiento.equals("izquierda") || movimiento.equals("derecha")){

                    for (int n = 0 ; n < jugador.getAncho() ; n++){
                        mover(movimiento);
                        Complementos.dormir(40);
                    }
                }else{
                     for (int n = 0 ; n < jugador.getLargo(); n++){
                        mover(movimiento);
                        Complementos.dormir(40);
                    }
                }
                //verCuadro();
                //Complementos.dormir(2000);
            }
        }
    }
    
    private boolean movimientoValido(String movimiento){
        boolean res=true;
        switch(movimiento){
            case "izquierda" : res = validarMovimiento(-1,0);
                break;
            case "derecha"   : res = validarMovimiento(1,0);
                break;
            case "arriba"    : res = validarMovimiento(0,-1);
                break;
            case "abajo"     : res = validarMovimiento(0,1);
                break;   
        }
        return res;
    }
    
    private boolean validarMovimiento(int x,int y){
        boolean res = false;
        int maxX = tablero.getNroColumnas();
        int maxY = tablero.getNroFilas();
        int posX = jugador.getPosX()+x;
        int posY = jugador.getPosY()+y;
        System.out.println(maxX+" "+posX+" "+maxY+" "+posY);
        if(posX >= 0 && posX < maxX && posY >= 0 && posY < maxY){
            res = true;
            jugador.setPosX(x);
            jugador.setPosY(y);
        }
        return res;
    }
    
    private void mover(String movimiento){
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
        modificarPosicion(-1,0);
    }
    
    private void caminarDerecha(){
        modificarPosicion(1,0);
    }
    
    private void caminarArriba(){
        modificarPosicion(0,-1);
    }
    
    private void caminarAbajo(){
        modificarPosicion(0,1);
    }
    
    private void modificarPosicion(int x,int y){
        jugador.setPosicionPersonaje(x, y);
        jugador.setFotograma();
        jugador.mostrarPersonaje();
    }  
}
