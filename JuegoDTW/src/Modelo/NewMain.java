/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.ArrayList;
import smile.math.distance.DynamicTimeWarping;

/**
 *
 * @author DroKaN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Diccionario d = new Diccionario();
        int n = d.getTamanioD();
        for(int i = 0 ; i < n ; i++){
            System.out.println(d.getPalabra(i).getMuestra().size());
        }
       // double res1 = DTW.d(des(m1), des(m2));
        //double res2 = DynamicTimeWarping.d(des(m1), des(m2));
        //System.err.println(res1);

        
    }
    
    private static double[] des(ArrayList<Double> m1){
        double[] res = new double[m1.size()];
        for(int i = 0 ; i < res.length ; i++){
            res[i]=m1.get(i);
        }
        return res;
    }
}
