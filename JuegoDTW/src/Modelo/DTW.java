/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import smile.math.distance.DynamicTimeWarping;

/**
 *
 * @author DroKaN
 */
public class DTW{
    
    private ArrayList<Double> resultados;
    private double[] m1;
    private double[] m2;
    
    public DTW(ArrayList<Double> resultados,ArrayList<Double> m1,ArrayList<Double> m2)
    {
        this.resultados = resultados;
        this.m1 = doubleArray(m1);
        this.m2 = doubleArray(m2);
    }
    public double run()
    {
        double res = DynamicTimeWarping.d(m1, m2);
       return res;
    }
    
     private  double[] doubleArray(ArrayList<Double> m1){
        double[] res = new double[m1.size()];
        for(int i = 0 ; i < res.length ; i++){
            res[i]=m1.get(i);
        }
        return res;
    }
}
