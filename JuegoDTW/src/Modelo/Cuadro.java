/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author DroKaN
 */
public class Cuadro {
    private JLabel cuadro;
    private String estado;
    private final int ancho;
    private final int largo;
    public Cuadro(int ancho,int largo){
        this.ancho = ancho;
        this.largo = largo;
        nuevoCuadro();
        estado = "";
    }
    private void nuevoCuadro(){
        cuadro = new JLabel();
        cuadro.setBorder(new LineBorder(Color.BLACK));
        cuadro.setSize(ancho, largo);
    }
    public void setPosicion(int x,int y){
        cuadro.setLocation(ancho*x,largo*y);
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public void verEstado(){
            if(estado.equals("trampa"))
                Complementos.nuevoIcono(estado+".png", cuadro, true);
            else if (estado.equals("hongo"))
                Complementos.nuevoIcono(estado+".png", cuadro, true);
            else
                Complementos.nuevoIcono("cuadro.png", cuadro, true);
    }
    
    public JLabel getCuadro(){
        return cuadro;
    }   
    public String getEstado(){
        return estado;
    }
}
