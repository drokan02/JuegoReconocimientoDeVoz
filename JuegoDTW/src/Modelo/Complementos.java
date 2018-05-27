/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author DroKaN
 */
public class Complementos {
    

    public static void nuevoIcono(String nombreImg,JLabel lb,boolean setTamanio){
       ImageIcon i = new ImageIcon("src/Imagenes/"+nombreImg);
       Icon icon;
       if(setTamanio)
            icon= new ImageIcon(i.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_DEFAULT));
       else 
            icon = new ImageIcon(i.getImage());
       lb.setIcon(icon);
    }
     
    public static void dormir(int tiempo){
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
