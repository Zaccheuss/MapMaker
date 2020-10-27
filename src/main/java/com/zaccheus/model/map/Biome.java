package com.zaccheus.model.map;

import java.awt.*;

public enum Biome {

    TROPICAL_RAINFOREST,
    SUBTROPICAL_DESERT,
    SAVANNA,
    TEMPERATE_RAINFOREST,
    FOREST,
    WOODLAND,
    GRASSLAND,
    BOREAL_FOREST,
    TUNDRA,
    MOUNTAIN,
    OCEAN,
    DEEP_OCEAN,
    SHALLOW_OCEAN;

    public int getBiomeColor(Biome biome) {
        switch (biome) {
            case TROPICAL_RAINFOREST: return new Color(11, 121, 11).getRGB();
            case SUBTROPICAL_DESERT: return new Color(210, 210, 108).getRGB();
            case SAVANNA: return new Color(126, 156, 39).getRGB();
            case TEMPERATE_RAINFOREST: return new Color(44, 153, 44).getRGB();
            case FOREST: return new Color(14, 88, 14).getRGB();
            case WOODLAND: return new Color(8, 54, 8).getRGB();
            case GRASSLAND: return new Color(101, 113, 47).getRGB();
            case BOREAL_FOREST: return new Color(123, 160, 99).getRGB();
            case TUNDRA: return new Color(178, 203, 203).getRGB();
            case MOUNTAIN: return new Color(212, 212, 212).getRGB();
            case OCEAN: return new Color(25, 41, 227).getRGB();
            case DEEP_OCEAN: return new Color(0, 1, 137).getRGB();
            case SHALLOW_OCEAN: return new Color(48, 64, 220).getRGB();
        }
        return new Color(0, 0, 0).getRGB(); //If nothing else works
    }
}
