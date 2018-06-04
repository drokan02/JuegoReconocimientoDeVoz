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
            tablero = new TableroJuego(12,12 );
            diccionario =  new Diccionario();
            ventana = new Ventana();
            movimiento = new ArrayList<>();
        }
        
        
        public void mostrarTablero()
        {

            cargarEventos();
            jugador.mostrarPersonaje(ventana, 72, 72);
            tablero.llenarTablero(ventana, 72, 72);
            tablero.ponerTrampas(40);
            tablero.poneHongos(30);
            ventana.setSize(72*15, 72*13);
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
            AudioSplite as = new AudioSplite();
            grabarMuestra();
            as.audioSplite();
            movimiento.addAll(as.getMuestras());
            System.out.println(movimiento.size());
            
            jugar();
            
        }
    }  
    
    private void grabarMuestra(){
        Grabador g =  new Grabador();
        for(int i = 0 ; i < 7 ; i++){
            if(i == 0)
                g.grabarVoz("");

            else if(i == 6){
                g.finalizar(); 
            }
            Complementos.dormir(1000);       
        }

    }
    
  
    
    private double menor(double n,double m){
        if(n < m)
            return n;
        return m;
    }
    
    private void jugar(){
        ArrayList<String> movimientos = new ArrayList<>();
        /*movimientos.add("derecha");
        movimientos.add("derecha");
        movimientos.add("abajo");
        movimientos.add("abajo");
        */
        for(Palabra p : movimiento){
            Palabra palabra = diccionario.buscarPalabra(p);
            movimientos.add(palabra.getPalabra());
        }
        
        new MoverJugador(jugador, tablero, movimientos,ventana.txtPuntos).start();
    }
}
