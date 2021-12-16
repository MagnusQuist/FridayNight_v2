package com.example.fridaynight_v2.utils;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public abstract class Interactable extends Region {
    //Attributes
    private int x, y;

    //Constructor
    public Interactable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public abstract ImageView getIcon();

    public void setY(int y) {
        this.y = y;
    }
}