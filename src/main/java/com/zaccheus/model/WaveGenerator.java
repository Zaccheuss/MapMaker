package com.zaccheus.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaveGenerator {
    private static final int NUMBER_OF_POINTS = 200;

    private static final double DEFAULT_LACUNARITY = 2;
    private static final double DEFAULT_PERSISTENCE = 0.5;
    private static final int DEFAULT_OCTAVES = 5;
    private static final int DEFAULT_SCALE = 20;

    private double lacunarity;  //Controls increase in frequency per octave
    private double persistence; //Controls decrease in amplitude per octave
    private int octaves;
    private int scale;

    public WaveGenerator() {
        this(DEFAULT_LACUNARITY, DEFAULT_PERSISTENCE, DEFAULT_OCTAVES, DEFAULT_SCALE);
    }

    public WaveGenerator(double lacunarity, double persistence, int octaves, int scale) {
        setLacunarity(lacunarity);
        setPersistence(persistence);
        setOctaves(octaves);
        setScale(scale);
    }

    public double[] combineWaves() {
        double[] output = new double[NUMBER_OF_POINTS];
        List<double[]> waveList = generateWaves();
        //Sum all arrays
        for (double[] wave : waveList) {
            for (int i = 0; i < output.length; i++) {
                output[i] += wave[i];
            }
        }
        return output;
    }

    public List<double[]> generateWaves() {
        double[] freqArr = generateFrequencyArray();
        double[] ampArr = generateAmplitudeArray();
        int[] phaseArr = generatePhaseArray();

        List<double[]> waveList = new ArrayList<>();

        for (int i = 0; i < octaves; i++) {
            waveList.add(new SineWave(ampArr[i], freqArr[i], phaseArr[i]).generateOutputArray());
        }
        return waveList;
    }

    public double[] generateFrequencyArray() {
        double[] freqArr = new double[octaves];
        for (int i = 0; i < octaves; i++) {
            freqArr[i] = Math.pow(lacunarity, i);
        }
        return freqArr;
    }

    public double[] generateAmplitudeArray() {
        double[] ampArr = new double[octaves];
        for (int i = 0; i < octaves; i++) {
            ampArr[i] = Math.pow(persistence, i);
        }
        return ampArr;
    }

    public int[] generatePhaseArray() {
        int[] phaseArr = new int[octaves];
        Random rand = new Random();
        for (int i = 0; i < octaves; i++) {
            phaseArr[i] = rand.nextInt(100);
        }
        return phaseArr;
    }


    //Setters
    public void setLacunarity(double lacunarity) {
        this.lacunarity = lacunarity;
    }

    public void setPersistence(double persistence) {
        if (persistence > 1.0 && persistence < 0.0) {
            this.persistence = persistence;
        } else {
            this.persistence = DEFAULT_PERSISTENCE;
        }
    }

    public void setOctaves(int octaves) {
        if (octaves > 0) {
            this.octaves = octaves;
        } else {
            this.octaves = DEFAULT_OCTAVES;
        }
    }

    public void setScale(int scale) {
        if (scale > 0) {
            this.scale = scale;
        } else {
            this.scale = DEFAULT_SCALE;
        }
    }
}
