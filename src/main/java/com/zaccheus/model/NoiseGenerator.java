package com.zaccheus.model;

import com.zaccheus.util.ArrayTools;
import com.zaccheus.util.MapTools;

import java.util.ArrayList;
import java.util.List;

public class NoiseGenerator {

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 700;
    private static final double DEFAULT_LACUNARITY = 2.9;
    private static final double DEFAULT_PERSISTENCE = 0.4;
    private static final int DEFAULT_OCTAVES = 4;
    private static final int DEFAULT_SCALE = 160;

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
        setLacunarity(lacunarity);
        setPersistence(persistence);
        setOctaves(octaves);
        setScale(scale);
        this.height = height;
        this.width = width;
    }

    public double[][] combineArrays() {
        double[][] output = new double[width][height];
        List<double[][]> mapList = generateMaps();
        //Sum all arrays
        for (double[][] map : mapList) {
            for (int i = 0; i < output.length; i++) { //Loop through height
                for (int j = 0; j < output[0].length; j++) { //Loop through width
                    output[i][j] += map[i][j];
                }
            }
        }

        output = ArrayTools.normalizeData(output, 1);
        return output;
    }

    public double[][] applyFalloffMap(double[][] input) {
        int height = input.length;
        int width = input[0].length;
        double[][] falloffMap = generateFalloffMap(height, width);
        for (int i = 0; i < input.length; i++) { //Loop through height
            for (int j = 0; j < input[0].length; j++) { //Loop through width
                input[i][j] *= falloffMap[i][j];
            }
        }
        return input;
    }

    private double[][] generateFalloffMap(int height, int width) {
        return MapTools.createGaussian(height, width, 1.1, 230, 230);
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
        if (persistence < 1.0 && persistence > 0.0) {
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

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }
    }
    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        } else {
            this.width = DEFAULT_WIDTH;
        }
    }
}
