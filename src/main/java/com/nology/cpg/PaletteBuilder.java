package com.nology.cpg;

import java.awt.*;

public class PaletteBuilder {

    protected Color base;
    protected int size;

    public PaletteBuilder(Color base, int size) {
        this.base = base;
        this.size = size;
    }

    public Color getBase() {
        return base;
    }
    public int getSize() {
        return size;
    }
}
