/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mathworks.toolbox.javabuilder.*;
import comparar_muestras.dtwClass;
import java.io.File;
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
        TableroJuego t = new TableroJuego(12, 12);
        t.llenarTablero(new JFrame(), 72, 72);
        t.ponerTrampas(40);
        t.poneHongos(40);
        for(int n = 0 ; n  < 12 ; n++)
        {
            for (int m = 0 ; m < 12 ; m++)
            {   String s = t.getCuadro(n, m).getEstado();
                if(s.equals("hongo"))
                    System.out.println(s);
            }
        }
        
       

        
    }
    
}
