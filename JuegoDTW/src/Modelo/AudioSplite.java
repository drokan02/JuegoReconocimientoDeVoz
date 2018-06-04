/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DroKaN
 */
public class AudioSplite {

    ArrayList<Palabra> muestras;
    public AudioSplite(){
        muestras = new ArrayList<>();
    }
 
    public void audioSplite(){
        String rutaSox ="D:\\programas\\sox-14-4-2\\sox";
        String rutaAudio ="D:\\Documentos\\Repositorios git\\JuegoReconocimientoDeVoz\\JuegoDTW\\rec.wav";
        String rutaSalida = "D:\\Documentos\\Repositorios git\\JuegoReconocimientoDeVoz\\JuegoDTW\\Muestras\\m.wav";
       
        
         try {
             ProcessBuilder pb4 = new ProcessBuilder(rutaSox,"-V3",rutaAudio,rutaSalida, "silence", "1", "0.2", "0.4%", "1", "0.2", "0.4%", ":", "newfile", ":", "restart");
             pb4.start();
             
        } catch (Exception ex) {
            
        }
    }
    
    public ArrayList<Palabra> getMuestras(){
        Grabador g = new Grabador();
        for(int n = 1 ; n < 5 ; n++){
            Palabra p = new Palabra();
            File f = new File("Muestras/m00"+n+".wav");
            if(f.length() > 1000){
                p.setAudio(f);
                p.setMuestra(g.muestraDeAudio(f));
                muestras.add(p);
            }
        }
        return muestras;
    
    }
    
}