package com.zaccheus.model.map;

import java.awt.*;

public enum Biome {

    SNOW,
    TUNDRA,
    BARE,
    SCORCHED,
    TIAGA,
    SHRUBLAND,
    TEMPERATE_DESERT,
    TEMPERATE_RAINFOREST,
    TEMP_DECIDUOUS_FOREST,
    GRASSLAND,
    TROPICAL_RAINFOREST,
    TROPICAL_SEASONAL_FOREST,
    SUBTROPICAL_DESERT,

    LOW_MOUNTAIN,
    MED_MOUNTAIN,
    MOUNTAIN,
    OCEAN,
    DEEP_OCEAN,
    SHALLOW_OCEAN,
    BEACH;

    public int getBiomeColor(Biome biome) {
        switch (biome) {
            case SNOW: return new Color(210, 210, 210).getRGB();
            case TUNDRA: return new Color(159, 167, 145).getRGB();
            case BARE: return new Color(170, 170, 170).getRGB();
            case SCORCHED: return new Color(111, 111, 111).getRGB();
            case TIAGA: return new Color(132, 132, 107).getRGB();
            case SHRUBLAND: return new Color(188, 206, 112).getRGB();
            case TEMPERATE_DESERT: return new Color(191, 196, 118).getRGB();
            case TEMPERATE_RAINFOREST: return new Color(105, 175, 84).getRGB();
            case TEMP_DECIDUOUS_FOREST: return new Color(133, 168, 105).getRGB();
            case GRASSLAND: return new Color(92, 121, 59).getRGB();
            case TROPICAL_RAINFOREST: return new Color(33, 139, 23, 255).getRGB();
            case TROPICAL_SEASONAL_FOREST: return new Color(46, 120, 28).getRGB();
            case SUBTROPICAL_DESERT: return new Color(147, 150, 50).getRGB();

            case MOUNTAIN: return new Color(210, 210, 210).getRGB();
            case MED_MOUNTAIN: return new Color (120, 120, 120).getRGB();
            case LOW_MOUNTAIN: return new Color(142, 167, 142).getRGB();
            case OCEAN: return new Color(25, 41, 227).getRGB();
            case DEEP_OCEAN: return new Color(0, 1, 137).getRGB();
            case SHALLOW_OCEAN: return new Color(48, 64, 220).getRGB();
            case BEACH: return new Color(207, 188, 103).getRGB();
        }
        return new Color(0, 0, 0).getRGB(); //If nothing else works

    }
}
