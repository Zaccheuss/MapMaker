package com.zaccheus.writer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class MapWriter {

    public static void generateColorImage(double[][] data) {
        generateColorImage(data, "saved-map");
    }

    public static void generateColorImage(double[][] data, String fileName) {
        BufferedImage image = new BufferedImage(data.length, data[0].length, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < data[0].length; y++) {
            for (int x = 0; x < data.length; x++) {
                if (data[x][y] > 1) {
                    data[x][y] = 1;
                }
                if (data[x][y] < 0) {
                    data[x][y] = 0;
                }

                if (data[x][y] < 0.30) {
                    image.setRGB(x, y, new Color(0, 1, 137).getRGB());
                } else if (data[x][y] < 0.38) {
                    image.setRGB(x, y, new Color(25, 41, 227).getRGB());
                }  else if (data[x][y] < 0.44) {
                    image.setRGB(x, y, new Color(48, 64, 220).getRGB());
                } else if (data[x][y] < 0.46) {
                    image.setRGB(x, y, new Color(227, 222, 88).getRGB());
                } else if (data[x][y] < 0.60) {
                    image.setRGB(x, y, new Color(7, 168, 0).getRGB());
                } else if (data[x][y] < 0.65) {
                    image.setRGB(x, y, new Color(78, 69, 31, 255).getRGB());
                } else if (data[x][y] < 0.7) {
                    image.setRGB(x, y, new Color(97, 94, 94, 255).getRGB());
                } else if (data[x][y] < 0.8) {
                    image.setRGB(x, y, new Color(176, 171, 165, 255).getRGB());
                } else {
                    image.setRGB(x, y, new Color(255, 248, 239, 255).getRGB());
                }
            }
        }

        writeToImage(image, fileName);
    }

    private static void writeToImage(BufferedImage image, String fileName) {
        try {
            Path outputFile = Paths.get(fileName + ".png");
            ImageIO.write(image, "png", outputFile.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Failure to write to image file");
        }
    }

}
