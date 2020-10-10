package com.zaccheus.model;

import com.zaccheus.util.ArrayTools;

import java.util.ArrayList;
import java.util.List;

public class NoiseGenerator {

    private static final int DEFAULT_WIDTH = 100;
    private static final int DEFAULT_HEIGHT = 100;
    private static final double DEFAULT_LACUNARITY = 2;
    private static final double DEFAULT_PERSISTENCE = 0.5;
    private static final int DEFAULT_OCTAVES = 5;
    private static final int DEFAULT_SCALE = 20;

    private double lacunarity;  //Controls increase in frequency per octave
    private double persistence; //Controls decrease in amplitude per octave
    private int octaves;
    private int scale;
    private int height;
    private int width;

    public NoiseGenerator() {
        this(DEFAULT_LACUNARITY, DEFAULT_PERSISTENCE, DEFAULT_OCTAVES, DEFAULT_SCALE,
                DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    public NoiseGenerator(double lacunarity, double persistence, int octaves, int scale, int height, int width) {
        this.lacunarity = lacunarity;
        this.persistence = persistence;
        this.octaves = octaves;
        this.scale = scale;
        this.height = height;
        this.width = width;
    }

    public double[][] combineArrays() {
        double[][] output = new double[height][width];
        List<double[][]> mapList = generateMaps();
        //Sum all arrays
        for (double[][] map : mapList) {
            for (int i = 0; i < output.length; i++) { //Loop through height
                for (int j = 0; j < output[0].length; j++) { //Loop through width
                    output[i][j] += map[i][j];
                }
            }
        }
        //Get average of each point
        for (int i = 0; i < output.length; i++) { //Loop through height
            for (int j = 0; j < output[0].length; j++) { //Loop through width
                output[i][j] /= octaves;
            }
        }
        ArrayTools.normalizeData(output, 1);

        return output;
    }

    private List<double[][]> generateMaps() {
        double[] freqArr = generateFrequencyArray();
        double[] ampArr = generateAmplitudeArray();

        List<double[][]> mapList = new ArrayList<>();
        for (int i = 0; i < octaves; i++) {
            mapList.add(new NoiseMap(ampArr[i], freqArr[i], scale, height, width).generateOutputArray());
        }
        return mapList;
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
