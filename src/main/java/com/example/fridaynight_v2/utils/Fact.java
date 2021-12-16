package com.example.fridaynight_v2.utils;

import com.example.fridaynight_v2.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fact extends Interactable {
    // Attributes
    private final String image = "images/fact.png";
    private String fact;
    private ImageView icon;

    public Fact(String fact, int x, int y) {
        super(x, y);
        this.fact = fact;
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

    public String getFact() {
        return this.fact;
    }

    @Override
    public ImageView getIcon() {
        return this.icon;
    }
}
