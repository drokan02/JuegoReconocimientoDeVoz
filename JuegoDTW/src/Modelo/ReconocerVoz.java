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
public class ReconocerVoz extends Thread{
    private final ArrayList<Double> m1;
    private final ArrayList<Double> m2;
    private final ArrayList<Double> res;
    
    public ReconocerVoz(ArrayList<Double> res,ArrayList<Double> m1, ArrayList<Double> m2)
    {
         this.res = res;
         this.m1 = m1;
         this.m2 = m2;
    }
}
