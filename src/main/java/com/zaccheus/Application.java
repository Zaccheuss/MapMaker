package com.zaccheus;

import com.zaccheus.model.map.MapGenerator;
import com.zaccheus.model.wave.WaveGenerator;
import com.zaccheus.writer.MapWriter;
import com.zaccheus.writer.WaveWriter;

public class Application {

    public static void main(String[] args) {

        //The console these are printing out to may need to be resized to fit the complete
        // length of the wave and map on the screen.

        //Generate and print to console a wave with custom inputs
        WaveGenerator waveGen = new WaveGenerator(2.1, 0.8, 4, 40);
        WaveWriter.printWaveToConsoleHorizontally(waveGen.generateWave());

        //Generate and save to the image "sample_map.png" a map with default inputs
        MapGenerator mapGen = new MapGenerator();
        MapWriter.generateColorImage(mapGen.generateMap(false), "sample_map");

        //Generate and save to the image "sample_island_map.png" an island map with default inputs
        MapWriter.generateColorImage(mapGen.generateMap(true), "sample_island_map");

        //Generate and print to console an ASCII art map using custom inputs
        System.out.println("\n\n\n\n"); //Space this out after the wave is printed
        MapGenerator asciiGen = new MapGenerator(2.9, 0.4, 4, 40, 50, 150);
        MapWriter.generateASCII(asciiGen.generateMap(false));

    }

}
