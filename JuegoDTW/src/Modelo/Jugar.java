/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author DroKaN
 */
public class Jugar extends Thread{
    Jugador jugador;
    TableroJuego tablero;
    ArrayList<String> movimientos;
    JLabel puntuacion;
    public Jugar(Jugador jugador,TableroJuego tablero, ArrayList<String> movimientos,JLabel puntuacion)
    {
        this.jugador = jugador;
        this.tablero = tablero;
        this.movimientos = movimientos;
        this.puntuacion = puntuacion;
    }
    
    public void run(){
        moverJugador();
    }
    
    private void moverJugador(){
        for(String movimiento : movimientos){
            if(!ganarJuego()){
                if(jugador.getVidas()> 0){
                    if(movimientoValido(movimiento)){
                        if(movimiento.equals("izquierda") || movimiento.equals("derecha")){

                            for (int n = 0 ; n < jugador.getAncho() ; n++){
                                mover(movimiento);
                                Complementos.dormir(25);
                            }
                        }else{
                             for (int n = 0 ; n < jugador.getLargo(); n++){
                                mover(movimiento);
                                Complementos.dormir(25);
                            }
                        }
                        verCuadro();
                        Complementos.dormir(100);
                    }
                }else{
                    perderJuego();
                }
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
    
    private void verCuadro(){
        int x = jugador.getPosX();
        int y = jugador.getPosY();
        int puntos = tablero.revelarCuadro(x, y);
        jugador.setVidas(puntos);
        puntuacion.setText(jugador.getVidas()+"");
    }

    private void perderJuego() {
        tablero.setMensaje("perder");
        tablero.mostrarMensaje();
    }

    private boolean ganarJuego() {
        boolean res = false;
        int x = jugador.getPosX()-tablero.getNroFilas()+1;
        int y = jugador.getPosY()-tablero.getNroFilas()+1;
        if(x == 0 && y == 0){
            res = false;
            tablero.mostrarMensaje();
        }
        return res;
    }
}
