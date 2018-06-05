/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mathworks.toolbox.javabuilder.MWException;
import comparar_muestras.dtwClass;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DroKaN
 */
public class Diccionario {
    MatlabDTW dtw;
    ArrayList<Palabra> palabras;
    BufferedReader lecturaDiccionario;
    PrintWriter escrituraDiccionario;
    File diccionario;
    
    public Diccionario(){
        dtw = new MatlabDTW();
        palabras = new ArrayList<>();
        diccionario = new File("src/Diccionario/diccionario.txt");
        crearLecturaEscritura();
        cargarDiccionario();
    }
    
    
    private void crearLecturaEscritura(){
        try {
            lecturaDiccionario = new BufferedReader(new FileReader(diccionario));
            escrituraDiccionario = new PrintWriter(new BufferedWriter(new FileWriter(diccionario,true)));
        } catch (IOException ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarDiccionario(){
        try {
            while(lecturaDiccionario.ready()){
                Palabra palabra = new Palabra();
                String p = lecturaDiccionario.readLine();
                File audio = new File("src/Diccionario/"+p+".wav");
                palabra.setPalabra(p);
                palabra.setAudio(audio);
                palabra.setMuestra(new Grabador().muestraDeAudio(audio));
                palabras.add(palabra);
            }
                } catch (Exception ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void agregarPalabra(Palabra p){
        try {
            escrituraDiccionario.write(p.getPalabra()+"\n");
            palabras.add(p);
        } catch (Exception ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Palabra buscarPalabra(String palabra){
        Palabra res = null;
        int i=0;
        while(i< palabras.size()){
            if(palabra.equals(palabras.get(i).getPalabra()))
                res = palabras.get(i);
        }
        return res;
    }
    
    public Palabra buscarPalabra(Palabra palabra){
        int indice = 0;
        Double menor = Double.POSITIVE_INFINITY;
        ArrayList<Double> distancias = new ArrayList<>();
        for(Palabra p : palabras){
            dtw.calcularDistancia(distancias, p.getPalabra(), palabra.getPalabra());   
        }
       
        for (int i = 0 ; i < distancias.size() ; i++){
            double d = distancias.get(i);
            System.out.println(d +" "+palabras.get(i).palabra);
            if(d < menor){
                menor = d;
                indice = i;
            }
        }
        System.out.println();
        return palabras.get(indice);
    }
    
    public Palabra buscar(Palabra palabra){
        int indice = 0;

        Double menor = Double.POSITIVE_INFINITY;
        ArrayList<Double> distancias = new ArrayList<>();
        for(Palabra p : palabras){
            DTW dtwm = new DTW(distancias, p.getMuestra(), palabra.muestra); 
            distancias.add(dtwm.run());
            System.err.println(distancias.size());
        }
        System.err.println("mm");
        for (int i = 0 ; i < distancias.size() ; i++){
            double d = distancias.get(i);
            System.out.println(d +" "+palabras.get(i).palabra);
            if(d < menor){
                menor = d;
                indice = i;
            }
        }
        System.out.println();
        return palabras.get(indice);
    }
    
    public Palabra getPalabra(int indice){
        return palabras.get(indice);
    }
    public void eliminarPalabra(Palabra p){

    }
    
    public int getTamanioD(){
        return palabras.size();
    }
    private double menor(double a,double b){
        if(a < b)
            return a;
        else
            return b;
    }
}

