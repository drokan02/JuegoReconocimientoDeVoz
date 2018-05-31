/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Modelo.dtwMejorado;
import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author DroKaN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       ControlJuego c = new ControlJuego();
       c.convinarMuestras();
       Grabador g = new Grabador();
       int res=0;
       
       ArrayList<Convinacion> con = c.convinaciones;
       for(Convinacion a : con){
           System.out.println(a.getConvinacionT()+" " +a.getMuestra().size());
       }
       /*
       for(int i=0 ; i < 10 ; i++){
            new dtwMejorado(resultados,con.get(i).getMuestra(), con.get(0).getMuestra()).start();    
       }
       
       while(res<10){
           res = resultados.size();
           Complementos.dormirHilo(1000);
       }
       for(Double d:resultados){
           System.out.print(d);
       }
*/
    }
    
}
