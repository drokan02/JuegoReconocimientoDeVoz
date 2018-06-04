/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class TrimAudio {
    
    private static final int WINDOW_MILLIS = 1;
    private static final int FADE_MILLIS = 2;
    private static final int MIN_SILENCE_MILLIS = 4;
    private static final int MIN_VOICE_MILLIS = 200;
        
    private static double threshold = 0.0001d;

    private static double[] fadeInFactors;
    private static double[] fadeOutFactors;

    
    public double getAutocorrellationThreshold() {
        return threshold;
    }

    public void setAutocorrellationThreshold(double threshold) {
        this.threshold = threshold;
    }

        
    public static ArrayList<Double> removeSilence(double[] voiceSample, float sampleRate) {
        int oneMilliInSamples = (int)sampleRate / 1000;
        int length = voiceSample.length;
        int minSilenceLength = MIN_SILENCE_MILLIS * oneMilliInSamples;
        int minActivityLength = getMinimumVoiceActivityLength(sampleRate);
        boolean[] result = new boolean[length];
        
        if(length < minActivityLength) {
            return arrayList(voiceSample);
        }

        int windowSize = WINDOW_MILLIS * oneMilliInSamples;
        double[] correllation = new double[windowSize];
        double[] window = new double[windowSize];
        for(int position = 0; position + windowSize < length; position += windowSize) {
            System.arraycopy(voiceSample, position, window, 0, windowSize);
            double mean = bruteForceAutocorrelation(window, correllation);
            Arrays.fill(result, position, position + windowSize, mean > threshold);
        }
       
        mergeSmallSilentAreas(result, minSilenceLength);
        int silenceCounter = mergeSmallActiveAreas(result, minActivityLength);
   
        if (silenceCounter > 0) {
            
            int fadeLength = FADE_MILLIS * oneMilliInSamples;
            initFadeFactors(fadeLength);
            double[] shortenedVoiceSample = new double[voiceSample.length - silenceCounter];
            int copyCounter = 0;
            for (int i = 0; i < result.length; i++) {
                if (result[i]) {
                    int startIndex = i;
                    int counter = 0;
                    while (i < result.length && result[i++]) {
                        counter++;
                    }
                    int endIndex = startIndex + counter;
                    applyFadeInFadeOut(voiceSample, fadeLength, startIndex, endIndex);
                    System.arraycopy(voiceSample, startIndex, shortenedVoiceSample, copyCounter, counter);
                    copyCounter += counter;
                }
            }
            return arrayList(shortenedVoiceSample);
        } else {
            return arrayList(voiceSample);
        }
    }

  
    private static int getMinimumVoiceActivityLength(float sampleRate) {
        return MIN_VOICE_MILLIS * (int) sampleRate / 1000;
    }


    private static void applyFadeInFadeOut(double[] voiceSample, int fadeLength, int startIndex, int endIndex) {
        int fadeOutStart = endIndex -  fadeLength;
        for(int j = 0; j < fadeLength; j++) {
            voiceSample[startIndex + j] *= fadeInFactors[j];
            voiceSample[fadeOutStart + j] *= fadeOutFactors[j];
        }
    }

    private static int mergeSmallActiveAreas(boolean[] result, int minActivityLength) {
        boolean active;
        int increment = 0;
        int silenceCounter = 0;
        for(int i = 0; i < result.length; i += increment) {
            active = result[i];
            increment = 1;
            while((i + increment < result.length) && result[i + increment] == active) {
                increment++;
            }
            if(active && increment < minActivityLength) {
                // convert short activity to opposite
                Arrays.fill(result, i, i + increment, !active);
                silenceCounter += increment;
            } 
            if(!active) {
                silenceCounter += increment;
            }
        }
        return silenceCounter;
    }

    private static void mergeSmallSilentAreas(boolean[] result, int minSilenceLength) {
        boolean active;
        int increment = 0;
        for(int i = 0; i < result.length; i += increment) {
            active = result[i];
            increment = 1;
            while((i + increment < result.length) && result[i + increment] == active) {
                increment++;
            }
            if(!active && increment < minSilenceLength) {
                Arrays.fill(result, i, i + increment, !active);
            } 
        }
    }

    private static void initFadeFactors(int fadeLength) {
        fadeInFactors = new double[fadeLength];
        fadeOutFactors = new double[fadeLength];
        for(int i = 0; i < fadeLength; i ++) {
            fadeInFactors[i] = (1.0d / fadeLength) * i;
        }
        for(int i = 0; i < fadeLength; i ++) {
            fadeOutFactors[i] = 1.0d - fadeInFactors[i];
        }
    }

    private static double bruteForceAutocorrelation(double[] voiceSample, double[] correllation) {
        Arrays.fill(correllation, 0);
        int n = voiceSample.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                correllation[j] += voiceSample[i] * voiceSample[(n + i - j) % n];
            }
        }
        double mean = 0.0d;
        for(int i = 0; i < voiceSample.length; i++) {
            mean += correllation[i];
        }
        return mean / correllation.length;        
    }
    
    public static ArrayList<Double> arrayList(double[]a){
        ArrayList<Double> res = new ArrayList<>();
        for(int i = 0 ; i < a.length ; i++){
            res.add(a[i]);
        }
        return res;
    }
    
}

