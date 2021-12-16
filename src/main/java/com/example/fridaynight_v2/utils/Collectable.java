package com.example.fridaynight_v2.utils;

import com.example.fridaynight_v2.Main;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Collectable extends Interactable {
    // Attributes
    private String image;
    private final double ap; // Alcohol percentage.
    private final String type; // Type and ap for each object cannot be changed (final)
    private ImageView icon;

    // Constructor
    public Collectable(double ap, String type, int x, int y, String pathToImg) {
        super(x,y);
        this.ap = ap;
        this.type = type;
        this.image = pathToImg;
        setIcon();
    }

    // Methods
    public void setIcon() {
        this.icon = new ImageView();
        this.icon.setFitWidth(100);
        this.icon.setFitHeight(100);
        Image image = new Image(Main.class.getResourceAsStream(this.image));
        this.icon.setImage(image);
    }

    public ImageView getIcon() {
        return this.icon;
    }

    public double getAp() {
        return ap;
    }

    public String getType() {
        return type;
    }
}