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

        //There should always be snow if the temperature is low so we don't get oceans near the poles
        if (temperature < 0.15) {
            biome = SNOW;
        }

        //If the biome is not snow (i.e. near the poles) then height is checked because that will always determine
        // where mountains and oceans are. After that, temperature and humidity assigns the rest of the biomes.
        if (biome != SNOW) {
            if (height < DEEP_OCEAN_HEIGHT) {
                biome = DEEP_OCEAN;
            } else if (height < OCEAN_HEIGHT) {
                biome = OCEAN;
            } else if (height < SHALLOW_OCEAN_HEIGHT) {
                biome = SHALLOW_OCEAN;
            } else if (height < BEACH_HEIGHT) {
                biome = BEACH;
            } else if (height > MOUNTAIN_HEIGHT) {
                biome = MOUNTAIN;
            } else if (height > MED_MOUNTAIN_HEIGHT) {
                biome = MED_MOUNTAIN;
            } else if (height > LOW_MOUNTAIN_HEIGHT) {
                biome = LOW_MOUNTAIN;
            }  else {
                if (temperature < 0.25) {
                    if (humidity < 0.167) {
                        biome = SCORCHED;
                    } else if (humidity < 0.333) {
                        biome = BARE;
                    } else if (humidity < 0.500) {
                        biome = TUNDRA;
                    } else if (humidity >= 0.500) {
                        biome = SNOW;
                    } else {
                        System.out.println("can't assign biome, temperature > 0.25");
                    }
                } else if (temperature < 0.50) {
                    if (humidity < 0.333) {
                        biome = TEMPERATE_DESERT;
                    } else if (humidity < 0.667) {
                        biome = SHRUBLAND;
                    } else if (humidity >= 0.667) {
                        biome = TIAGA;
                    } else {
                        System.out.println("can't assign biome, temperature > 0.50");
                    }
                } else if (temperature < 0.75) {
                    if (humidity < 0.167) {
                        biome = TEMPERATE_DESERT;
                    } else if (humidity < 0.5) {
                        biome = GRASSLAND;
                    } else if (humidity < 0.833) {
                        biome = TEMP_DECIDUOUS_FOREST;
                    } else if (humidity >= 0.833) {
                        biome = TEMPERATE_RAINFOREST;
                    } else {
                        System.out.println("can't assign biome, temperature > 0.75");
                    }
                } else if (temperature >= 0.75) {
                    if (humidity < 0.167) {
                        biome = SUBTROPICAL_DESERT;
                    } else if (humidity < 0.333) {
                        biome = GRASSLAND;
                    } else if (humidity < 0.667) {
                        biome = TROPICAL_SEASONAL_FOREST;
                    } else if (humidity >= 0.667) {
                        biome = TROPICAL_RAINFOREST;
                    } else {
                        System.out.println("can't assign biome, temperature >= 0.75");
                    }
                } else {
                    System.out.println("I've made a huge mistake");
                }
            }
        }

        return biome;
    }

    public int getColor() {
        return getBiome().getBiomeColor(getBiome());
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
