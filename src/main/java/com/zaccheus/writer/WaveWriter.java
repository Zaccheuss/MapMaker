package com.zaccheus.writer;

import com.zaccheus.util.ArrayTools;

public final class WaveWriter {

    public static void printWaveToConsoleVertically(double[] data) {
        for (double point : data) {
            System.out.println("*".repeat((int) point));
        }
    }

    public static void printWaveToConsoleHorizontally(double[] input) {
        String[][] output = generateHorizontal2DArray(input);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[1].length; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] generateHorizontal2DArray(double[] data) {
        int[] wave = doubleArrayToIntArray(data);
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

    private static int[] doubleArrayToIntArray(double[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = (int) input[i];
        }

        return output;
    }

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

