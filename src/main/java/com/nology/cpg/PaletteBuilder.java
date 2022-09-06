package com.nology.cpg;

import java.awt.*;

public class PaletteBuilder {

    protected Color base;
    protected int size;

    protected String rgb;

    public PaletteBuilder(){

    }
    public PaletteBuilder(Color base, int size) {
        this.base = base;
        this.size = size;
    }

    public PaletteBuilder(Color base, int size, String rgb) {
        this.base = base;
        this.size = size;
        this.rgb = rgb;
    }

    public Color getBase() {
        return base;
    }
    public int getSize() {
        return size;
    }
    public String getRGB() {
        return rgb;
    }
}
