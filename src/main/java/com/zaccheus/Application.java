package com.zaccheus;

import com.zaccheus.model.NoiseGenerator;
import com.zaccheus.model.NoiseMap;
import com.zaccheus.model.SineWave;
import com.zaccheus.model.WaveGenerator;
import com.zaccheus.writer.WaveWriter;

public class Application {

    public static void main(String[] args) {

        NoiseGenerator gen = new NoiseGenerator(1.2, 0.4, 3, 80, 500, 500);
    }

}
