package com.zaccheus.model;

import com.zaccheus.model.map.MapGenerator;
import com.zaccheus.model.map.Tile;
import com.zaccheus.util.ArrayTools;
import com.zaccheus.util.MapTools;

import java.util.List;

public class MapCombiner {

    private int height;
    private int width;
    private boolean hasEquator;

    private double[][] heightMap;
    private double[][] temperatureMap;
    private double[][] humidityMap;

    public MapCombiner(int height, int width, boolean hasEquator) {
        this.height = height;
        this. width = width;
        this.hasEquator = hasEquator;
        combineMaps();
    }

    private void combineMaps() {
        heightMap = new MapGenerator(2.9, 0.4, 5, 160, height, width)
                .generateMap(false);
        temperatureMap = new MapGenerator(2.9, 0.4, 4, 160, height, width)
                .generateMap(false);
        humidityMap = new MapGenerator(2.9, 0.4, 3, 160, height, width)
                .generateMap(false);

        //Apply a falloff map to the temperature map to simulate an equator
        if (hasEquator) {
            MapTools.applyFalloffMap(temperatureMap, 5, 5000, 125);
        }
    }

    public Tile[][] generateTileMap() {
        Tile[][] output = new Tile[width][height];
        for (int i = 0; i < heightMap.length; i++) { //Loop through height
            for (int j = 0; j < heightMap[0].length; j++) { //Loop through width
                output[i][j] = new Tile(heightMap[i][j], temperatureMap[i][j], humidityMap[i][j]);
            }
        }
        return output;
    }

}
