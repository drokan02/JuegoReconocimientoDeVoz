/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;
import java.util.ArrayList;
/**
 * Write a description of class Complemento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Complemento extends Thread 
{
    ArrayList<Integer> res;
    int n1;
    int n2;
    public Complemento(ArrayList<Integer> res, int n1, int n2){
        this.res = res;
        this.n1 = n1;
        this.n2 = n2;
    }
    public void run(){
        int sum = 0;
        int i,j,aux=0;
        for(i = 0 ; i < 60000 ; i++){
            for(j = 0 ; j < 60000 ; j++){
                aux += Math.abs(i-j)+Math.abs(i-j);
            }
        }
        res.add(aux);
        System.out.println(res.size());
    }   
}