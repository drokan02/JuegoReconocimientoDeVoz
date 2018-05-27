/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Write a description of class Prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prueba
{
   ArrayList<Integer> datos = new ArrayList<>();
   ArrayList<Integer> sumas = new ArrayList<>();
   public void llenarDatos(){
       for(int i = 0 ; i < 6 ; i++){
           datos.add(i);
        }
   }
   public void sumar(){
       boolean lleno = false;
       int tiempo = 1;
       for(int i = 0 ; i < 6 ; i++){
           new Complemento(sumas,datos.get(i),1).start();
        }
        
        
        while(!lleno){
            if(sumas.size()== datos.size()){
                lleno = true;
                System.out.println("se lleno "+sumas.size());
            }else{
                System.out.println(tiempo++ +" sec");
                try {
                Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
           
          
        }
      
   }
}