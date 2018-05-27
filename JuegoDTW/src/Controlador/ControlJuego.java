/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Tablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author DroKaN
 */
public class ControlJuego implements ActionListener
{
        private final ArrayList<Convinacion> convinaciones;
        private final Tablero tablero;
        
        public ControlJuego()
        {
            convinaciones = new ArrayList<>();
            tablero = new Tablero();
        }
        
        
        public void mostrarTablero()
        {
            cargarImagenes();
            cargarEventos();
            tablero.setLocationRelativeTo(null);
            tablero.setVisible(true);         
        }
        
        private void cargarEventos()
        {
            tablero.btMover.addActionListener(this);
        }
        
        private void cargarImagenes()
        {  
            Complementos.nuevoIcono("torre.png", tablero.lbTorre, true);
        }
        
        private void convinar()
        {
           Diccionario d = new Diccionario();
           int tam = d.getTamanioD();
           System.out.println(tam);
           for(int i = 0 ; i < tam ; i++){  
                for(int j = 0 ; j < tam ; j++){ 
                    for(int k = 0 ; k < tam ; k++){
                        Convinacion con = new Convinacion();
                        con.addPalabra(d.getPalabra(i));
                        con.addPalabra(d.getPalabra(j));
                        con.addPalabra(d.getPalabra(k));
                        convinaciones.add(con);
                    }
                }
                
           }
        }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == tablero.btMover){
            String[] m = {"izquierda","derecha","arriba"};
            new Mover(tablero.lbTorre, m).start();

        }
    }   
        
}
