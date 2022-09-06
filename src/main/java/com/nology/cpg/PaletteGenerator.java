package com.nology.cpg;

import java.awt.*;
import java.util.Random;

public class PaletteGenerator {

    public static Color getColour(Color base) {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        if (base != null) {

            r = (r + base.getRed()) / 2;
            g = (g + base.getGreen()) / 2;
            b = (b + base.getBlue()) / 2;
        }
        return new Color(r, g, b);
    }

    public static Color getColorMatchRGB(Color base, String rgb) {


            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
        if(base != null) {
            if(rgb.equals("r")) {
                r = (r + base.getRed()) / 2;
                g *= 0.4;
                b *= 0.1;
            }
            else if(rgb.equals("g")) {
                g = (g + base.getGreen()) / 2;
                r *= 0.25;
                b *= 0.4;
            }
            else {
                b = (b + base.getBlue()) /2;
                r *= 0.2;
                g *= 0.4;
            }

        }
        return new Color(r, g, b);
    }

    public String rgbToHex(Color rgb) {
        return String.format("#%02x%02x%02x", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

    public Palette createPalette(Color base, int size) {

        Color[] palette = new Color[size];
        if (base == null) {
            palette[0] = getColour(null); ///Create base colour to work from
            for (int i = 1; i < size; i++) {
                palette[i] = getColour(palette[0]);
            }
        } else {
            for (int i = 0; i < size; i++) {
                palette[i] = getColour(base);
            }
        }
        Palette p = new Palette(palette);
        return p;
    }

    public Palette createPaletteFromRGB(Color base, int size, String rgb) {

        Color[] palette = new Color[size];
        if (base == null) {
            palette[0] = getColorMatchRGB(null, rgb); ///Create base colour to work from
            for (int i = 1; i < size; i++) {
                palette[i] = getColorMatchRGB(palette[0], rgb);
            }
        } else {
            for (int i = 0; i < size; i++) {
                palette[i] = getColorMatchRGB(base, rgb);
            }
        }
        Palette p = new Palette(palette);
        return p;
    }



}
