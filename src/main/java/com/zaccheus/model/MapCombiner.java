package com.zaccheus.model;

import com.zaccheus.model.map.MapGenerator;
import com.zaccheus.model.map.Tile;
import com.zaccheus.util.ArrayTools;
import com.zaccheus.util.MapTools;

import java.util.List;

public class MapCombiner {

    private double[][] heightMap;
    private double[][] temperatureMap;
    private double[][] humidityMap;

    public MapCombiner() {
        heightMap = new MapGenerator().generateMap(false);
        temperatureMap = new MapGenerator()
                .generateMap(false);
        MapTools.applyFalloffMap(temperatureMap, 5, 230, 140);
        humidityMap = new MapGenerator()
                .generateMap(false);
    }

    public Tile[][] generateTileMap() {
        Tile[][] output = new Tile[700][700];
        for (int i = 0; i < heightMap.length; i++) { //Loop through height
            for (int j = 0; j < heightMap[0].length; j++) { //Loop through width
                output[i][j] = new Tile(heightMap[i][j], temperatureMap[i][j], humidityMap[i][j]);
            }
        }
        return output;
    }

}
