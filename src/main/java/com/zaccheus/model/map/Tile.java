package com.zaccheus.model.map;

import static com.zaccheus.model.map.Biome.*;
import static com.zaccheus.model.map.MapVariables.*;

public class Tile {

    private double height;
    private double temperature;
    private double humidity;

    public Tile(double height, double temperature, double humidity) {
        this.height = height;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public Biome getBiome() {
        Biome biome = null;

        if (height < DEEP_OCEAN_HEIGHT) {
            biome = DEEP_OCEAN;
        } else if (height < OCEAN_HEIGHT) {
            biome = OCEAN;
        } else if (height < SHALLOW_OCEAN_HEIGHT) {
            biome = SHALLOW_OCEAN;
        } else if (height > MOUNTAIN_HEIGHT) {
            biome = MOUNTAIN;
        }

        if (biome == null) {
            biome = SUBTROPICAL_DESERT; //Testing the above if statements
        }

        return biome;
    }

    public int getColor() {
        return getBiome().getBiomeColor(getBiome());
    }


}
