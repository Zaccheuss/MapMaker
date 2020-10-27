package com.zaccheus.model.map;

public final class MapVariables {
    //Any tile below this height value is always an ocean, regardless of biome
    static final double DEEP_OCEAN_HEIGHT = 0.3;
    static final double OCEAN_HEIGHT = 0.38;
    static final double SHALLOW_OCEAN_HEIGHT = 0.43;

    //Any tile above this height value is always a mountain, regardless of biome
    static final double MOUNTAIN_HEIGHT = 0.9;
}
