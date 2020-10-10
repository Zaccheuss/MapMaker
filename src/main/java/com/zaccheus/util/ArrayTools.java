package com.zaccheus.util;

public final class ArrayTools {
    public static double[] normalizeData(double[] data, double newMaxValue) {
        double[] normalizedData = new double[data.length];
        double max = findArrayMax(data);
        double min = findArrayMin(data);
        for (int i = 0; i < data.length; i++) {
            normalizedData[i] = newMaxValue * (data[i] - min) / (max - min);
        }
        return normalizedData;
    }

    public static double findArrayMax(double[] data) {
        double max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public static int findArrayMax(int[] data) {
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public static double findArrayMin(double[] data) {
        double min = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    public static int findArrayMin(int[] data) {
        int min = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
}
