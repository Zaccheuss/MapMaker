package com.zaccheus.util;

public final class MapTools {
    private static final double GAUSSIAN_AMPLITUDE = 1;
    private static final double SIGMA_X = 200;
    private static final double SIGMA_Y = 200;

    public static double[][] createGaussian(int height, int width) {
        return createGaussian(height, width, GAUSSIAN_AMPLITUDE, SIGMA_X, SIGMA_Y);
    }

    public static double[][] createGaussian(int height, int width, double amplitude, double sigmaX, double sigmaY) {
        double[][] gaussianArray = new double[width][height];

        //Start at the center
        int x0 = width / 2;
        int y0 = height / 2;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double partX = Math.pow((x - x0), 2) / (2 * Math.pow(sigmaX, 2));
                double partY = Math.pow((y - y0), 2) / (2 * Math.pow(sigmaY, 2));

                gaussianArray[x][y] = amplitude * Math.exp(-(partX + partY));
            }
        }
        return gaussianArray;
    }

}
