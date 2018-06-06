/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import dtw.Dtw;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DroKaN
 */
public class MatlabDTW extends Thread{
    Dtw dtw ;
    public MatlabDTW(){
        nuevoDTW();
    }
    
    
    private void nuevoDTW(){
        try {
            dtw = new Dtw();
        } catch (MWException ex) {
            
        }
    }
    
    
     public void calcularDistancia(ArrayList<Double> distancia,String m1, String m2){
         
        try {
            Object[] results = null;
            String d1 = "src/Diccionario/";
            String d2 = "Muestras/";
            //se ejecuta el metodo dtw.distancia, mandando la direccion donde estan las muestras
            results = dtw.distancia(1,d1+m1+".wav",d2+m2+".wav");
            MWArray result = (MWNumericArray) results[0];
            double[][] total = (double[][])result.toArray();
            distancia.add(total[0][0]);
        } catch (MWException ex) {

        }
      
       
     }
}
