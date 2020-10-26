package com.zaccheus.writer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This is a utility class for printing noisemaps either to an image or to the
 * console in ASCII.
 */
public final class MapWriter {

    private static final String IMAGES_FOLDER = "images/";

    /**
     * Writes the map to a color image with the name "saved-map.png"
     * @param input two dimensional array representing the map
     */
    public static void generateColorImage(double[][] input) {
        generateColorImage(input, "saved-map");
    }

    /**
     * Writes the map to a color image with the specified file name
     * <p>
     * The height values and associated colors within this method can be changed to
     * show different terrain
     * @param input two dimensional array representing the map
     */
    public static void generateColorImage(double[][] input, String fileName) {
        BufferedImage image = new BufferedImage(input.length, input[0].length, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < input[0].length; y++) {
            for (int x = 0; x < input.length; x++) {
                if (input[x][y] > 1) {
                    input[x][y] = 1;
                }
                if (input[x][y] < 0) {
                    input[x][y] = 0;
                }

                if (input[x][y] < 0.30) {
                    image.setRGB(x, y, new Color(0, 1, 137).getRGB());
                } else if (input[x][y] < 0.38) {
                    image.setRGB(x, y, new Color(25, 41, 227).getRGB());
                }  else if (input[x][y] < 0.44) {
                    image.setRGB(x, y, new Color(48, 64, 220).getRGB());
                } else if (input[x][y] < 0.46) {
                    image.setRGB(x, y, new Color(227, 222, 88).getRGB());
                } else if (input[x][y] < 0.60) {
                    image.setRGB(x, y, new Color(7, 168, 0).getRGB());
                } else if (input[x][y] < 0.65) {
                    image.setRGB(x, y, new Color(78, 69, 31, 255).getRGB());
                } else if (input[x][y] < 0.7) {
                    image.setRGB(x, y, new Color(97, 94, 94, 255).getRGB());
                } else if (input[x][y] < 0.8) {
                    image.setRGB(x, y, new Color(176, 171, 165, 255).getRGB());
                } else {
                    image.setRGB(x, y, new Color(255, 248, 239, 255).getRGB());
                }
            }
        }

        writeToImage(image, fileName);
    }

    /**
     * Writes the map to the console using ASCII characters
     * @param input two dimensional array representing the map
     */
    public static void generateASCII(double [][] input) {
        StringBuilder output = new StringBuilder();

        for (int y = 0; y < input[0].length; y++) {
            for (int x = 0; x < input.length; x++) {
                if (input[x][y] > 1) {
                    input[x][y] = 1;
                }
                if (input[x][y] < 0) {
                    input[x][y] = 0;
                }

                if (input[x][y] < 0.30) {
                    output.append(" ");
                } else if (input[x][y] < 0.38) {
                    output.append(".");
                }  else if (input[x][y] < 0.44) {
                    output.append(":");
                } else if (input[x][y] < 0.46) {
                    output.append("-");
                } else if (input[x][y] < 0.60) {
                    output.append("=");
                } else if (input[x][y] < 0.65) {
                    output.append("+");
                } else if (input[x][y] < 0.7) {
                    output.append("*");
                } else if (input[x][y] < 0.8) {
                    output.append("#");
                } else {
                    output.append("%");
                }
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    //Writes the image to specified file name
    private static void writeToImage(BufferedImage image, String fileName) {
        try {
            Path outputFile = Paths.get(IMAGES_FOLDER + fileName + ".png");
            ImageIO.write(image, "png", outputFile.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Failure to write to image file");
        }
    }

}
