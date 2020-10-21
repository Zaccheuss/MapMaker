package com.zaccheus.model;

import com.zaccheus.noise.OpenSimplexNoise;
import com.zaccheus.util.ArrayTools;

import java.util.Random;

/**
 * An instance of this class represents a two dimensional array created through
 * classes in the noise package.
 */
public class NoiseMap {

    private Random rand = new Random();
    private OpenSimplexNoise noise;
    private double amplitude;
    private double frequency;
    private double scale;
    private int height;
    private int width;

    /**
     * Creates a new object with custom inputs
     * @param amplitude the output of the noise function is multiplied by this value
     * @param frequency the input of the noise function is multiplied by this value
     * @param scale scales the input of the noise function
     * @param height height of the array
     * @param width width of the array
     */
    public NoiseMap(double amplitude, double frequency, int scale, int height, int width) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.scale = scale;
        this.height = height;
        this.width = width;
        noise = new OpenSimplexNoise(rand.nextLong());
    }

    /**
     * Creates a two dimensional array using the inputs of this class and the
     * {@link com.zaccheus.noise.OpenSimplexNoise} function
     * @return two dimensional array
     */
    public double[][] generateOutputArray() {
        double[][] output = new double[width][height];

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
