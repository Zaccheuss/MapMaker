package com.zaccheus.model;

import org.junit.Assert;
import org.junit.Test;

public class WaveGeneratorTests {

    private WaveGenerator sut;

    @Test
    public void frequency_array_generated_correctly() {
        sut = new WaveGenerator(2, 0.5, 4, 2);
        Assert.assertArrayEquals(new double[] {1, 2, 4, 8}, sut.generateFrequencyArray(), 0.01);
    }

    @Test
    public void amplitude_array_generated_correctly() {
        sut = new WaveGenerator(2, 0.5, 4, 2);
        Assert.assertArrayEquals(new double[] {1, 0.5, 0.25, 0.125}, sut.generateAmplitudeArray(), 0.01);
    }

}
