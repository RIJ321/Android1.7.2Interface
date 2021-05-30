package com.example.android172;

import java.util.ArrayList;

public class Model{
    private int id, color;

    public Model(int id, int color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
