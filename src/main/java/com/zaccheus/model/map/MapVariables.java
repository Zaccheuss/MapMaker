package com.zaccheus.model.map;

public final class MapVariables {
    //Any tile below this height value is always an ocean, regardless of biome
    static final double DEEP_OCEAN_HEIGHT = 0.45;
    static final double OCEAN_HEIGHT = 0.49;
    static final double SHALLOW_OCEAN_HEIGHT = 0.52;
    static final double BEACH_HEIGHT = 0.55;

    //Any tile above this height value is always a mountain, regardless of biome
    static final double LOW_MOUNTAIN_HEIGHT = 0.80;
    static final double MED_MOUNTAIN_HEIGHT = 0.86;
    static final double MOUNTAIN_HEIGHT = 0.9;
}
