package com.example.m_elblasy.psedv2.list;

import android.graphics.Bitmap;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.activities.Projects;
import com.example.m_elblasy.psedv2.adapters.ListOFProjects;

import java.util.ArrayList;
import java.util.List;

public class ItemsForCells {
    private int images;
    private Bitmap image;
    private ArrayList<ArrayList<ProjectsList>> listOFProjects = new ArrayList<>(7);

    public ItemsForCells(){

    }
    public ItemsForCells(ArrayList<ArrayList<ProjectsList>> listOFProjects) {
        this.listOFProjects = listOFProjects;
    }

    public ItemsForCells(int image) {
        this.images = image;
    }



    public int getImages() {
        return images;
    }

    public ArrayList<ArrayList<ProjectsList>> getListOFProjects() {
        return listOFProjects;
    }

    public void setListOFProjects(ArrayList<ArrayList<ProjectsList>> listOFProjects) {
        this.listOFProjects = listOFProjects;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getImage1() {
        return images;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

     public static ArrayList<ItemsForCells> getList() {
        ArrayList<ItemsForCells> items = new ArrayList<>();
        items.add(new ItemsForCells(R.drawable.computer));
        items.add(new ItemsForCells(R.drawable.communication));
        items.add(new ItemsForCells(R.drawable.civil));
        items.add(new ItemsForCells(R.drawable.power));
        items.add(new ItemsForCells(R.drawable.mechanic));
        items.add(new ItemsForCells(R.drawable.marine));
        items.add(new ItemsForCells(R.drawable.arch));
        return items;
    }
}
