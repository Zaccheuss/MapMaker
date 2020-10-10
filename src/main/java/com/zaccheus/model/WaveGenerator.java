package com.zaccheus.model;

public class WaveGenerator {

    SineWave wave1 = new SineWave(80, 2, 5, 200, 0, 1);
    SineWave wave2 = new SineWave(40, 4, 9, 200, 0, 1);
    SineWave wave3 = new SineWave(30, 8, 0, 200, 0, 1);
    SineWave wave4 = new SineWave(10, 16, 2, 200, 0, 1);

    private static final double DEFAULT_LACUNARITY = 2;
    private static final double DEFAULT_PERSISTENCE = 0.5;
    private static final int DEFAULT_OCTAVES = 4;
    private static final int DEFAULT_SCALE = 1;

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
        double[] output = new double[wave1.generateOutputArray().length];

        for (int i = 0; i < output.length; i++) {
            output[i] = (wave1.generateOutputArray()[i] +
                    wave2.generateOutputArray()[i] +
                    wave3.generateOutputArray()[i] +
                    wave4.generateOutputArray()[i]) / 4;
        }

        return output;
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
