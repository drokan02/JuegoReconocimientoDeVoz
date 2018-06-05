/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DroKaN
 */
public class ControlJuego implements ActionListener
{
        Jugador jugador;
        TableroJuego tablero;
        Diccionario diccionario;
        private ArrayList<Palabra> movimiento;
        private Ventana ventana;
        
        public ControlJuego()
        {
            jugador = new Jugador("", 5);
            tablero = new TableroJuego(12,12);
            //diccionario =  new Diccionario();
            ventana = new Ventana();
            movimiento = new ArrayList<>();
        }
        
        
        public void mostrarTablero()
        {

            cargarEventos();
            tablero.setMensaje(40, 40);
            tablero.setMensaje("ganar");
            ventana.add(tablero.getCuadroMensaje());
            jugador.mostrarPersonaje(ventana, 40, 40);
            tablero.llenarTablero(ventana, 40, 40);
            //tablero.ponerTrampas(60);
            tablero.poneHongos(30);
            ventana.setSize(40*17, 40*14);
            ventana.txtPuntos.setText(jugador.getVidas()+"");
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
       
        }
        
        private void cargarEventos()
        {
            ventana.btJugar.addActionListener(this);
        }
        

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(ventana.btJugar == e.getSource()){
           /* AudioSplite as = new AudioSplite();
            grabarMuestra();
            as.audioSplite();
          
            movimiento = (as.getMuestras());
            System.out.println(movimiento.size());*/
            
            jugar();
            
        }
    }  
    
    private void grabarMuestra(){
        Grabador g =  new Grabador();
        for(int i = 0 ; i < 8 ; i++){
            if(i == 0)
                g.grabarVoz("");

            else if(i == 7){
                g.finalizar(); 
            }
            Complementos.dormir(1000);       
        }

    }
    
  
     private Palabra Muestra(){
        Grabador g =  new Grabador();
        Palabra p = new Palabra();
        for(int i = 0 ; i < 9 ; i++){
            if(i == 0)
                g.grabarVoz("");
            else if(i == 8){
                g.finalizar();
                File muestra = g.getAudio();
                p.setAudio(muestra);
                p.setMuestra(g.muestraDeAudio(muestra));
            }
            Complementos.dormir(1000);       
        }
        return p;
    }
    private double menor(double n,double m){
        if(n < m)
            return n;
        return m;
    }
    
    private void jugar(){
        ArrayList<String> movimientos = new ArrayList<>();
        movimientos.add("derecha");
        movimientos.add("derecha");
        movimientos.add("abajo");
        movimientos.add("abajo");
        //movimientos.add("arriba");
       // movimientos.add("arriba");
        //movimientos.add("izquierda");
        //movimientos.add("abajo");
      /*  for(Palabra p : movimiento){
            Palabra palabra = diccionario.buscarPalabra(p);
            movimientos.add(palabra.getPalabra());
        }*/
        
        new Jugar(jugador, tablero, movimientos,ventana.txtPuntos).start();
    }
}
