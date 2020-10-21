package com.zaccheus.util;

/**
 * A variety of tools that can be used to manipulate two dimensional arrays.
 */
public final class MapTools {
    private static final double GAUSSIAN_AMPLITUDE = 1.1;
    private static final double SIGMA_X = 230;
    private static final double SIGMA_Y = 230;

    /**
     * Applies a Gaussian array to the given two dimensional array
     * <p>
     * A Gaussian array is a two dimensional normal distribution. This means the values near
     * the center of the two dimensional array are higher and then slowly fade off to zero
     * near the "edges" of the array. The given array is multiplied by this array of values
     * and returned.
     * @param input two dimensional array to apply Gaussian function to
     * @return two dimensional array
     */
    public static double[][] applyFalloffMap(double[][] input) {
        return applyFalloffMap(input, GAUSSIAN_AMPLITUDE, SIGMA_X, SIGMA_Y);
    }

    /**
     * Applies a Gaussian array to the given two dimensional array
     * <p>
     * A Gaussian array is a two dimensional normal distribution. This means the values near
     * the center of the two dimensional array are higher and then slowly fade off to zero
     * near the "edges" of the array. The given array is multiplied by this array of values
     * and returned.
     * @param input two dimensional array to apply Gaussian function to
     * @param amplitude higher value will cause more raised terrain near the center of the array,
     *                  typically 1.1
     * @param sigma_x higher value will show more terrain along the x axis
     * @param sigma_y higher value will show more terrain along the y axis
     * @return two dimensional array
     */
    public static double[][] applyFalloffMap(double[][] input, double amplitude, double sigma_x, double sigma_y) {
        int height = input.length;
        int width = input[0].length;
        double[][] falloffMap = createGaussian(height, width, amplitude, sigma_x, sigma_y);
        for (int i = 0; i < input.length; i++) { //Loop through height
            for (int j = 0; j < input[0].length; j++) { //Loop through width
                input[i][j] *= falloffMap[i][j];
            }
        }
        return input;
    }

    //Creates a Gaussian array with default values
    private static double[][] createGaussian(int height, int width) {
        return createGaussian(height, width, GAUSSIAN_AMPLITUDE, SIGMA_X, SIGMA_Y);
    }

    //Creates a Gaussian array with custom values
    private static double[][] createGaussian(int height, int width, double amplitude, double sigmaX, double sigmaY) {
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
