/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author DroKaN
 */
public class ControlJuego {
        ArrayList<Convinacion> convinaciones;
        
        public ControlJuego(){
            convinaciones = new ArrayList<>();
        }
        
        private void convinar(){
           Diccionario d = new Diccionario();
           for(int i = 0 ; i < d.getTamanioD() ; i++){
                Convinacion con = new Convinacion();
                d.getPalabra(i);
                for(int j = 0 ; j < d.getTamanioD() ; j++){
                    d.getPalabra(j);
                    for(int k = 0 ; k < d.getTamanioD() ; k++){
                        d.getPalabra(k);
                    }
                }
                convinaciones.add(con);
           }
        }
}
