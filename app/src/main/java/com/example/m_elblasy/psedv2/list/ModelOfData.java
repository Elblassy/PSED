package com.example.m_elblasy.psedv2.list;

import android.graphics.Bitmap;

public class ModelOfData {
    private String name;
    private Bitmap image;
    private Bitmap image2;
    private String dis;

    public ModelOfData(String name, Bitmap image ,Bitmap image2, String dis) {
        this.name = name;
        this.image = image;
        this.image2 = image2;
        this.dis = dis;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage2() {
        return image2;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDis() {
        return dis;
    }
}
