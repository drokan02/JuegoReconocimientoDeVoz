/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DroKaN
 */
public class Complementos {
    

    public static Icon nuevoIcono(String nombreImg,int width,int height){
       ImageIcon i = new ImageIcon("src/pruebas/"+nombreImg);
       Icon icon;
       if(width > 0 && height > 0)
            icon= new ImageIcon(i.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
       else 
            icon = new ImageIcon(i.getImage());
       return icon;
    }
     
    public static void dormirHilo(int tiempo){
           try {
                Thread.sleep(tiempo);
              } catch (Exception ex) {
              }
    } 
    
    public static double menor(double n,double m)
    {
        if(n < m)
            return n;
        return m;
    }
    
     public static double mayor(double n,double m)
    {
        if(n > m)
            return n;
        return m;
    }
}
