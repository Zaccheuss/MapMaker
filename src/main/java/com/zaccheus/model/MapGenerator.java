package com.zaccheus.model;

import com.zaccheus.util.ArrayTools;
import com.zaccheus.util.MapTools;

import java.util.ArrayList;
import java.util.List;

/**
 * An instance of this class is used to create and combine several {@link NoiseMap} instances
 * to produce a single two dimensional array that can then be printed out to the console or
 * as a color picture using the {@link com.zaccheus.writer.MapWriter} class
 */
public class MapGenerator {

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 700;
    private static final double DEFAULT_LACUNARITY = 2.9;
    private static final double DEFAULT_PERSISTENCE = 0.4;
    private static final int DEFAULT_OCTAVES = 4;
    private static final int DEFAULT_SCALE = 160;

    private double lacunarity;
    private double persistence;
    private int octaves;
    private int scale;
    private int height;
    private int width;

    /**
     * Creates a new map generator with default inputs
     * <p>
     * Use this if you want some good initial values for printing out a map
     */
    public MapGenerator() {
        this(DEFAULT_LACUNARITY, DEFAULT_PERSISTENCE, DEFAULT_OCTAVES, DEFAULT_SCALE,
                DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    /**
     * Creates a new map generator with custom inputs
     * <p>
     * Use this if you want to further edit map attributes.
     * @param lacunarity increases the frequency every octave, typically 2 or greater
     * @param persistence decreases the frequency every octave, typically less than 1
     * @param octaves amount of maps that will be generated and added togethers, typically 4-6
     * @param scale how zoomed in or zoomed out the map is, typically 150
     * @param height height in pixels
     * @param width width in pixels
     */
    public MapGenerator(double lacunarity, double persistence, int octaves, int scale, int height, int width) {
        setLacunarity(lacunarity);
        setPersistence(persistence);
        setOctaves(octaves);
        setScale(scale);
        setHeight(height);
        setWidth(width);
    }

    /**
     * Generate a height map based on this map generators settings
     * <p>
     * <pre>{@code MapGenerator gen = new MapGenerator();
     * double[][] mapToBePrinted = gen.generateMap();}</pre>
     * @return two dimensional array of elements normalized between 0 and 1
     */
    public double[][] generateMap(boolean applyFalloffMap) {
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
        if (applyFalloffMap) {
            MapTools.applyFalloffMap(output);
        }

        return output;
    }

    //Generate a number of maps (based on number of octaves) with decreasing amplitude and increasing frequency
    private List<double[][]> generateMaps() {
        double[] freqArr = generateFrequencyArray();
        double[] ampArr = generateAmplitudeArray();

        List<double[][]> mapList = new ArrayList<>();
        for (int i = 0; i < octaves; i++) {
            mapList.add(new NoiseMap(ampArr[i], freqArr[i], scale, height, width).generateOutputArray());
        }
        return mapList;
    }

    //Generate an array of frequencies based on the lacunarity value
    public double[] generateFrequencyArray() {
        double[] freqArr = new double[octaves];
        for (int i = 0; i < octaves; i++) {
            freqArr[i] = Math.pow(lacunarity, i);
        }
        return freqArr;
    }

    //Generate an array of amplitudes based on the persistence value
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
        this.persistence = persistence;
    }

    public void setOctaves(int octaves) {
        if (octaves > 0) {
            this.octaves = octaves;
        } else {
            this.octaves = DEFAULT_OCTAVES;
        }
    }

    public void setScale(int scale) {
        this.scale = scale;
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
