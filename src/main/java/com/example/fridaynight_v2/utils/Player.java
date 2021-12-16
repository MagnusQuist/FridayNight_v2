package com.example.fridaynight_v2.utils;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Player extends Interactable {

    private double intoxication = 0.0;
    private ArrayList<Collectable> inventory;
    private final String image = "File:images/avatar.png";
    private ImageView icon;

    public Player(int x,int y)
    {
        super(x, y);
        this.inventory = new ArrayList<Collectable>();
    }

    public void setIntoxication(double ap) {
        this.intoxication += ap;
    }

    public double getIntoxication() {
        return this.intoxication;
    }

    public void decreaseIntoxication(double ap) {
        this.intoxication -= ap;
    }

    public String getImage() {
        return this.image;
    }

    @Override
    public ImageView getIcon() {
        return this.icon;
    }
}

