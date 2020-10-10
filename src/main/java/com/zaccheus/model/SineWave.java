package com.zaccheus.model;

import com.zaccheus.util.ArrayTools;

public class SineWave {

    private static final double DEFAULT_AMP = 10;
    private static final double DEFAULT_FREQ = 1;
    private static final double DEFAULT_PHASE = 0;
    private static final int DEFAULT_POINTS = 20;
    private static final int DEFAULT_START = 0;
    private static final int DEFAULT_END = 2;

    private double amplitude;
    private double frequency;
    private double phase;
    private int numberOfDataPoints;
    private int start;
    private final int end;

    public SineWave() {
        this(DEFAULT_AMP, DEFAULT_FREQ, DEFAULT_PHASE, DEFAULT_POINTS, DEFAULT_START, DEFAULT_END);
    }

    public SineWave(int numberOfDataPoints) {
        this(DEFAULT_AMP, DEFAULT_FREQ, DEFAULT_PHASE, numberOfDataPoints, DEFAULT_START, DEFAULT_END);
    }

    public SineWave(double amplitude, double frequency, double phase) {
        this(amplitude, frequency, phase, DEFAULT_POINTS, DEFAULT_START, DEFAULT_END);
    }

    public SineWave(double amplitude, double frequency, double phase, int numberOfDataPoints,
                             int start, int end) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phase = phase;

        //Make sure given inputs will work, else set to default values
        if (numberOfDataPoints <= 0) {
            this.numberOfDataPoints = DEFAULT_POINTS;
        } else {
            this.numberOfDataPoints = numberOfDataPoints;
        }
        if (end < start) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
        } else {
            this.start = start;
            this.end = end;
        }
    }

    //Generate waveform based on inputs
    public double[] generateOutputArray() {
        double[] output = new double[numberOfDataPoints];
        double[] input = generateInputArray();
        for (int i = 0; i < input.length; i++) {
            output[i] = amplitude * Math.sin(2 * Math.PI * frequency * input[i] + phase);
        }
        //Normalize data between 0 and the amplitude, if normalized to a static value here the console output is the
        // same regardless of amplitude
        output = ArrayTools.normalizeData(output, amplitude);
        return output;
    }

    //Generate values equally spaced between the start and end values and the number of data points
    private double[] generateInputArray() {
        double[] input = new double[numberOfDataPoints];
        input[0] = start;
        double step = (double) (end - start) / numberOfDataPoints;
        for (int i = 1; i < input.length; i++) {
            input[i] = input[i-1] + step;
        }

        return input;
    }
}
