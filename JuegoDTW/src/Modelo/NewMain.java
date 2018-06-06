/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mathworks.toolbox.javabuilder.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author DroKaN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MWException {
      
        File f = new File("Muestras/m001.wav");
        System.out.println(f.length());
        Grabador g = new Grabador();
        ArrayList<Double> d = g.muestra(f);
        System.out.println(d.size());
    }
    
}
