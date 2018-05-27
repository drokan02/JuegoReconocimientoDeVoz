/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author DroKaN
 */
public class DTW {
   

    public double matrizAcumulada(ArrayList<Double> s1,ArrayList<Double> s2){
        int x,y;
        double res;
        double[][] mA = matrizDistancia(s1, s2);
         x = s1.size(); 
         y = s2.size();
        if(mA[0].length > 0){
            
            for(int i = 1 ; i < x ; i++){
                mA[i][0] += mA[i-1][0];
            }
            
            for(int i = 1 ; i < y ; i++){
                mA[0][i] += mA[0][i-1];
            }
            
            for(int i = 1 ; i < x ; i++){
                 for(int j = 1 ; j < y ; j++){
                   mA[i][j] += minimo(mA[i-1][j],minimo(mA[i][j-1],mA[i-1][j-1]));
                }
            }

        }
        return(mA[x-1][y-1])/100;
        //return mA[x-1][y-1]/(x+y);
    }
    //calcula la distancia que existe entre ambas señales
    private double[][] matrizDistancia(ArrayList<Double> s1,ArrayList<Double> s2){
         int x = s1.size(), y=s2.size();
        
        if(x > 0 && y > 0){
            double[][] mD = new double[x][y];
            
            for(int i = 0 ; i < x ; i++){
                 for(int j = 0 ; j < y ; j++){
                   mD[i][j] = Math.abs(s1.get(i) - s2.get(j));
                }
            }
            return mD;//retornamos la matriz distancia
        }else 
            return new double[0][0];//si alguna de las señales no es valida retornamos una matriz vacia  
    }
    
    private double minimo(double n,double m){
        if(n<m)
            return n;
        else 
            return m;
    }
    
}
