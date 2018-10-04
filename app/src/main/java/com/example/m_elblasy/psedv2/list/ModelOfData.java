package com.example.m_elblasy.psedv2.list;

import android.graphics.Bitmap;

public class ModelOfData {
    private String name;
    private Bitmap image;
    private String dis;

    public ModelOfData(String name, Bitmap image , String dis) {
        this.name = name;
        this.image = image;
        this.dis = dis;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
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
