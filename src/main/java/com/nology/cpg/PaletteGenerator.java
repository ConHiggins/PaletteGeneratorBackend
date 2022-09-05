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

    public String rgbToHex(Color rgb) {
        return String.format("#%02x%02x%02x", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

    public Palette createPalette(Color base, int size) {

        Color[] palette = new Color[size];
        if (base == null) {
            palette[0] = getColour(base); ///Create base colour to work from
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



}
