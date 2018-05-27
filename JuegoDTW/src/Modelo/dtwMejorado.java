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
public class dtwMejorado extends Thread{
    
    private ArrayList<Double> resultados;
    private ArrayList<Double> m1;
    private ArrayList<Double> m2;
    
    public dtwMejorado(ArrayList<Double> resultados,ArrayList<Double> m1,ArrayList<Double> m2)
    {
        this.resultados = resultados;
        this.m1 = m1;
        this.m2 = m2;
    }
    public void run()
    {
        ArrayList<Double>  fIni = filaAcumulada(m1.get(0),null,m2);
        /**tomamos m1 como la muestra que estara en la cordenada y
         * asi que cada valor sera como una fila donde el ultimo valor
         * que se itere sera la primera fila de la planilla
         */
        for(int i = 1 ; i < m1.size() ; i++){
            fIni = filaAcumulada(m1.get(i), fIni, m2);
            
        }
        System.out.println(fIni.get(fIni.size()-1));
        //se agrega el ultimo valor de la fila que representa el camino mas corto
        resultados.add(fIni.get(fIni.size()-1));
    }
    //devuelve los valores acumulados de la siguiente fila
    public ArrayList<Double> filaAcumulada(double vCol,ArrayList<Double>  fIni,ArrayList<Double> m2){
        ArrayList<Double> res = new ArrayList<>();
        double valor;
        if(fIni == null){
            res.add(Math.abs(vCol-m2.get(0)));
            for(int i = 1 ; i < m2.size() ; i++){
               valor = Math.abs(vCol-m2.get(i))+m2.get(i-1);
               res.add(valor);
            }
        }else{
            for(int i = 0 ; i < m2.size() ; i++){
                if(i == 0){
                    valor = Math.abs(vCol-m2.get(i))+fIni.get(i);
                    res.add(valor);
                }else{
                    valor = Math.abs(vCol-m2.get(i)) + menor(res.get(i-1),menor(fIni.get(i),fIni.get(i-1)));
                    res.add(valor);
                }
            }
        }
            
        return res;
    }
    
    private double menor(double n,double m){
        if(n < m)
            return n;
        else 
            return m;
    }
}
