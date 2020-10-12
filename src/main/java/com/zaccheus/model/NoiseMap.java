package com.zaccheus.model;

import com.zaccheus.noise.OpenSimplexNoise;
import com.zaccheus.util.ArrayTools;

import java.util.Random;

public class NoiseMap {

    private static final double DEFAULT_AMP = 10;
    private static final double DEFAULT_FREQ = 1;
    private static final double DEFAULT_PHASE = 0;
    private static final int DEFAULT_POINTS = 200;
    private static final int DEFAULT_START = 0;
    private static final int DEFAULT_END = 2;

    private Random rand = new Random();
    private OpenSimplexNoise noise;
    private double amplitude;
    private double frequency;
    private double scale;
    private int height;
    private int width;

    public NoiseMap(double amplitude, double frequency, int scale, int height, int width) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.scale = scale;
        this.height = height;
        this.width = width;
        noise = new OpenSimplexNoise(rand.nextLong());
    }

    //Generate noisemap based on inputs
    public double[][] generateOutputArray() {
        double[][] output = new double[height][width];

        for (int i = 0; i < output.length; i++) { //Loop through height
            for (int j = 0; j < output[0].length; j++) { //Loop through width
                double x = i / scale;
                double y = j / scale;
                double point = amplitude * (noise.eval(frequency * x, frequency * y));
                output[i][j] = point;
            }
        }
        return output;
    }


}
