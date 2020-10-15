package com.zaccheus;

import com.zaccheus.model.NoiseGenerator;
import com.zaccheus.model.NoiseMap;
import com.zaccheus.model.SineWave;
import com.zaccheus.model.WaveGenerator;
import com.zaccheus.writer.MapWriter;
import com.zaccheus.writer.WaveWriter;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        //Good inputs for ASCII map
//        NoiseGenerator gen = new NoiseGenerator(
//                2.9,
//                .4,
//                4,
//                40,
//                50,
//                150);
        NoiseGenerator gen  = new NoiseGenerator();
//        double[][] generatedMap = (gen.combineArrays());
//
        MapWriter.generateColorImage(gen.applyFalloffMap(gen.combineArrays()));
//        MapWriter.generateASCII(gen.combineArrays());

//        WaveGenerator waveGen = new WaveGenerator(1.9, 0.6, 4, 40);
//        WaveWriter.printWaveToConsoleHorizontally(waveGen.combineWaves());
//
//        WaveGenerator wavedasdfGen = new WaveGenerator(2, 0.5, 4, 20);
//        System.out.println(Arrays.toString(wavedasdfGen.generateFrequencyArray()));
//        System.out.println(Arrays.toString(wavedasdfGen.generateAmplitudeArray()));



    }

}
