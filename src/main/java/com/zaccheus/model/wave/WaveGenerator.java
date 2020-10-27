package com.zaccheus.model.wave;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * An instance of this class is used to create and combine several {@link Wave} instances
 * to produce a single array that can be printed out using the {@link com.zaccheus.writer.WaveWriter} class
 */
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

    /**
     * Creates a new wave generator with default inputs
     * <p>
     * Use this if you want some good initial values for printing out a wave
     */
    public WaveGenerator() {
        this(DEFAULT_LACUNARITY, DEFAULT_PERSISTENCE, DEFAULT_OCTAVES, DEFAULT_SCALE);
    }

    /**
     * Creates a new wave generator with custom inputs
     * <p>
     * Use this if you want to further edit the wave attributes
     * @param lacunarity increases the frequency every octave, typically 2 or greater
     * @param persistence decreases the frequency every octave, typically less than 1
     * @param octaves amount of maps that will be generated and added togethers, typically 4-6
     * @param scale how zoomed in or zoomed out the wave is, typically 20
     */
    public WaveGenerator(double lacunarity, double persistence, int octaves, int scale) {
        setLacunarity(lacunarity);
        setPersistence(persistence);
        setOctaves(octaves);
        setScale(scale);
    }

    /**
     * Generate a wave based on this map generators settings
     * <p>
     * <pre>{@code WaveGenerator gen = new WaveGenerator();
     * double[] waveToBePrinted = gen.generateWave();}</pre>
     * @return array representing height values of the wave
     */
    public double[] generateWave() {
        double[] output = new double[NUMBER_OF_POINTS];
        List<double[]> waveList = generateWaves();
        //Sum all arrays
        for (double[] wave : waveList) {
            for (int i = 0; i < output.length; i++) {
                // May be a better way to this next part...needs further research
                output[i] += wave[i] * (scale / octaves);
            }
        }

        return output;
    }

    //Generate a number of waves (based on number of octaves) with decreasing amplitude and increasing frequency
    private List<double[]> generateWaves() {
        double[] freqArr = generateFrequencyArray();
        double[] ampArr = generateAmplitudeArray();
        int[] phaseArr = generatePhaseArray();

        List<double[]> waveList = new ArrayList<>();

        for (int i = 0; i < octaves; i++) {
            waveList.add(new Wave(ampArr[i], freqArr[i], phaseArr[i]).generateOutputArray());
        }
        return waveList;
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

    //Generate an array of phases with random values between 0 and 99
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
        if (scale > 0) {
            this.scale = scale;
        } else {
            this.scale = DEFAULT_SCALE;
        }
    }
}
