package com.zaccheus;

import com.zaccheus.model.NoiseGenerator;
import com.zaccheus.model.NoiseMap;
import com.zaccheus.model.SineWave;
import com.zaccheus.model.WaveGenerator;
import com.zaccheus.writer.MapWriter;
import com.zaccheus.writer.WaveWriter;

public class Application {

    public static void main(String[] args) {

        //Good inputs for ASCII map
//        NoiseGenerator gen = new NoiseGenerator(
//                2.9,
//                .4,
//                4,
//                50,
//                50,
//                150);
        NoiseGenerator gen  = new NoiseGenerator();

        MapWriter.generateColorImage(gen.combineArrays());
//        MapWriter.generateASCII(gen.combineArrays());
    }

}
