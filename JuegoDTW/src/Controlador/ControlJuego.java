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
            convinar();
        }
        
        private void convinar(){
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
        
}
