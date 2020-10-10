package com.zaccheus;

import com.zaccheus.model.SineWave;
import com.zaccheus.model.WaveGenerator;
import com.zaccheus.writer.WaveWriter;

public class Application {

    public static void main(String[] args) {
        SineWave wave = new SineWave(
                20,
                2,
                5,
                200,
                0,
                1
        );

        WaveGenerator waveGen = new WaveGenerator();

        WaveWriter.printWaveToConsoleHorizontally(waveGen.combineWaves());
    }

}
