package com.zaccheus;

import com.zaccheus.model.NoiseGenerator;
import com.zaccheus.model.NoiseMap;
import com.zaccheus.model.SineWave;
import com.zaccheus.model.WaveGenerator;
import com.zaccheus.writer.MapWriter;
import com.zaccheus.writer.WaveWriter;

public class Application {

    public static void main(String[] args) {

        NoiseGenerator gen = new NoiseGenerator(
                2.9,
                .4,
                4,
                160,
                1000,
                1000);
        MapWriter.generateColorImage(gen.combineArrays());
    }

}
