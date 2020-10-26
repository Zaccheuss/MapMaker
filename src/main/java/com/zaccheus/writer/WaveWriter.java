package com.zaccheus.writer;

import com.zaccheus.util.ArrayTools;

/**
 * This is a utility class for printing waves to the console. There is an option to
 * print the wave vertically (along the y-axis) or horizontally (along the x-axis).
 */
public final class WaveWriter {

    /**
     * Prints the wave to the console along the y-axis
     * @param input array representing the wave
     */
    public static void printWaveToConsoleVertically(double[] input) {
        for (double point : input) {
            System.out.println("*".repeat((int) point));
        }
    }

    /**
     * Prints the wave to the console along the x-axis
     * @param input array representing the wave
     */
    public static void printWaveToConsoleHorizontally(double[] input) {
        String[][] output = generateHorizontal2DArray(input);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[1].length; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }

    //Makes a 2d array so the wave can be printed horizontally
    private static String[][] generateHorizontal2DArray(double[] input) {
        int[] wave = doubleArrayToIntArray(input);
        int test1 = wave.length;
        int test2 = ArrayTools.findArrayMax(wave);
        String[][] waveForPrinting = new String[wave.length][ArrayTools.findArrayMax(wave)];
        for (int x = 0; x < waveForPrinting.length; x++) {
            for (int y = 0; y < waveForPrinting[x].length; y++) {
                if (y <= wave[x]) {
                    waveForPrinting[x][y] = "x";
                } else {
                    waveForPrinting[x][y] = " ";
                }
            }
        }
        return transpose(waveForPrinting);
    }

    //Turns a double array into an int array so we can print to the console.
    // Some data is lost this way but it works for this application
    private static int[] doubleArrayToIntArray(double[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = (int) input[i];
        }

        return output;
    }

    //Transposes a given 2d string array.
    // Useful for switching the wave from vertical to horizontal
    private static String[][] transpose(String[][] input) {
        int rows = input[0].length;
        int columns = input.length;
        String[][] output = new String[input[0].length][input.length];
        for (int i = 0; i < columns ; i++) {
            for (int j = 0; j < rows; j++) {
                output[j][i] = input[(columns - 1)  - i][(rows - 1) - j];

            }
        }
        return (output);
    }

}

