package com.zaccheus;

import com.zaccheus.model.SineWave;
import com.zaccheus.model.WaveGenerator;
import com.zaccheus.writer.WaveWriter;

public class Application {

    public static void main(String[] args) {

        WaveGenerator waveGen = new WaveGenerator(3, 0.7, 6, 80);
        WaveWriter.printWaveToConsoleHorizontally(waveGen.combineWaves());

    }

}
