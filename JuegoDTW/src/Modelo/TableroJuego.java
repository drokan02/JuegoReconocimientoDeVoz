/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JFrame;


/**
 *
 * @author DroKaN
 */
public class TableroJuego {
    private Cuadro[][] tablero;
    private int nroFilas;
    private int nroColumnas;

    public TableroJuego(int nroFilas,int nroColumnas){
        this.tablero = new Cuadro[nroFilas][nroColumnas];
        this.nroFilas = nroFilas;
        this.nroColumnas = nroColumnas;
    }
    
    public int getNroFilas() {
        return nroFilas;
    }

    public int getNroColumnas() {
        return nroColumnas;
    }
    
    public void llenarTablero(JFrame ventana,int anchoCuadro,int largoCuadro){
        for(int x = 0 ; x < nroFilas ;x++){
            for(int y = 0 ; y < nroColumnas ; y++){
                Cuadro cuadro = new Cuadro(anchoCuadro,largoCuadro);
                cuadro.setEstado("");
                cuadro.setPosicion(x, y);
                tablero[x][y] = cuadro;
                ventana.add(cuadro.getCuadro());
            }
        }
    }
    
    public void ponerTrampas(int nroTrampas){
        if(nroTrampas<tablero.length*0.5){
            for(int n = 1 ; n <= nroTrampas ; n++){
                boolean valido = false;
                while(!valido){
                    int x = (int)(Math.random()*nroFilas-1)+1;
                    int y = (int)(Math.random()*nroColumnas-1)+1;
                    Cuadro cuadro = tablero[x][y];
                    if(cuadro.getEstado().equals("")){
                        cuadro.setEstado("trampa");
                        valido = true;
                    }
                }
            }
        }
    }
    
    public void poneHongos(int nroHongos){
        if(nroHongos<tablero.length*0.5){
            for(int n = 1 ; n <= nroHongos ; n++){
                boolean valido = false;
                while(!valido){
                    int x = (int)(Math.random()*nroFilas-1)+1;
                    int y = (int)(Math.random()*nroColumnas-1)+1;
                    Cuadro cuadro = tablero[x][y];
                    if(cuadro.getEstado().equals("")){
                        cuadro.setEstado("Hongo");
                        valido = true;
                    }
                }
            }
        }
    }
    public void revelarCuadro(int x,int y){
        Cuadro cuadro = tablero[x][y];
        cuadro.verEstado();
    }
    
    
}
