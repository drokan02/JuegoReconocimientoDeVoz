/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author DroKaN
 */
public class TableroJuego {
    private Cuadro[][] tablero;
    private int nroFilas;
    private int nroColumnas;
    private Cuadro mensaje;
    public TableroJuego(int nroFilas,int nroColumnas){
        this.tablero = new Cuadro[nroFilas][nroColumnas];
        this.nroFilas = nroFilas;
        this.nroColumnas = nroColumnas;
    }
    
    public void setMensaje(int largo,int ancho){
        mensaje = new Cuadro(ancho*nroFilas, largo*nroFilas);
    }
    
    public JLabel getCuadroMensaje(){
      return mensaje.getCuadro();
    }
    
    public void setMensaje(String mensaje){
        this.mensaje.setEstado(mensaje);
    }
    public void mostrarMensaje(){
        mensaje.verEstado();
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
        int cont = (int)(nroColumnas*nroColumnas*0.5);
                while(cont > 0 ){
                    int x = (int)(Math.random()*nroFilas-1)+1;
                    int y = (int)(Math.random()*nroColumnas-1)+1;
                    Cuadro cuadro = tablero[x][y];
                    if(cuadro.getEstado().equals("")){
                        cuadro.setEstado("trampa");
                        cont--;
                    }
        }
    }
    
    public void poneHongos(int nroHongos){
        if(nroHongos<nroColumnas*nroColumnas*0.5){
            for(int n = 1 ; n <= nroHongos ; n++){
                boolean valido = false;
                while(!valido){
                    int x = (int)(Math.random()*nroFilas-1)+1;
                    int y = (int)(Math.random()*nroColumnas-1)+1;
                    Cuadro cuadro = tablero[x][y];
                    if(cuadro.getEstado().equals("")){
                        cuadro.setEstado("hongo");
                        valido = true;
                    }
                }
            }
        }
    }
    public int revelarCuadro(int x,int y){
        Cuadro cuadro = tablero[x][y];
        cuadro.verEstado();
        return puntos(cuadro);
    }
    
    private int puntos(Cuadro cuadro){
        int res = 0;
        String estado = cuadro.getEstado();
        
        if(estado.equals("trampa"))
            res = -1;
        else if(estado.equals("hongo"))
            res = 1;
        cuadro.setEstado("visto");
        return res;
    }
    
    public Cuadro getCuadro(int x, int y)
    {
        return tablero[x][y];
    }
    
}
