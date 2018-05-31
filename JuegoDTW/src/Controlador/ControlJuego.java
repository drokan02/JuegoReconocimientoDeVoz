/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Tablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DroKaN
 */
public class ControlJuego implements ActionListener
{
        ArrayList<Convinacion> convinaciones;
        private final Tablero tablero;
        private Palabra movimiento;
        public ControlJuego()
        {
            convinaciones = new ArrayList<>();
            tablero = new Tablero();
        }
        
        
        public void mostrarTablero()
        {
            cargarImagenes();
            cargarEventos();
            convinarMuestras();
            tablero.setLocationRelativeTo(null);
            tablero.setVisible(true);         
        }
        
        private void cargarEventos()
        {
            tablero.btGrabar.addActionListener(this);
            tablero.btMover.addActionListener(this);
        }
        
        private void cargarImagenes()
        {  
            Complementos.nuevoIcono("torre.png", tablero.lbTorre, true);
        }
        
        public void convinarMuestras()
        {
           Diccionario d = new Diccionario();
           int tam = d.getTamanioD();
           for(int i = 0 ; i < tam ; i++){
                for(int j = 0 ; j < tam ; j++){ 
                   
                        for(int k = 0 ; k < tam ; k++){
                            if(i != j && i != k && j != k){
                                Convinacion con = new Convinacion();
                                con.addPalabra(d.getPalabra(i));
                                con.addPalabra(d.getPalabra(j));
                                con.addPalabra(d.getPalabra(k));
                                
                                
                                convinaciones.add(con);
                            }
                        }
                }
                
           }
        }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == tablero.btGrabar){
            movimiento = grabarMuestra();
            if(movimiento.getMuestra().size()> 0){
                System.out.println(movimiento.getMuestra().size()+" "+convinaciones.size());
                
            }else
                JOptionPane.showMessageDialog(tablero, "no se entendio lo que dijo");
        }
        if (e.getSource() == tablero.btMover){
            realizarMovimientos(movimiento);
        }
    }  
    
    private Palabra grabarMuestra(){
        Grabador g =  new Grabador();
        Palabra p = new Palabra();
        for(int i = 0 ; i < 9 ; i++){
            if(i == 0)
                g.grabarVoz("");
            else if(i == 8){
                g.finalizar();
                File muestra = g.getAudio();
                p.setAudio(muestra);
                p.setMuestra(g.muestraDeAudio(muestra));
            }
            Complementos.dormir(1000);       
        }
        return p;
    }
    
    private void realizarMovimientos(Palabra p){
        ArrayList<Double> resultados = new ArrayList<>();
        int tamanioRes = 0;
        int indice = 0;
        double menor = 10000;
        for(int i = 0 ; i < 5 ;i++)
        {
            ArrayList<Double> m2 = convinaciones.get(i).getMuestra();
            new dtwMejorado(resultados, p.getMuestra(), m2).start();
        }
        
        while(tamanioRes < 5)
        {   
            tamanioRes = resultados.size();
            Complementos.dormir(1000);
        }
        
        for(int i = 0 ; i < tamanioRes ; i++){
            double aux = resultados.get(i);
            System.err.println(aux +" "+convinaciones.get(i).getConvinacionT());
           if(menor(menor,aux)!= menor){
               menor = aux;
               indice = i;
           }      
        }
        
        new Mover(tablero.lbTorre, convinaciones.get(indice)).start();
    }
    
    private double menor(double n,double m){
        if(n < m)
            return n;
        return m;
    }
        
}
