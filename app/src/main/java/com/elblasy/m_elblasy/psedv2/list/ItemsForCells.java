package com.elblasy.m_elblasy.psedv2.list;

import android.graphics.Bitmap;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.activities.Projects;
import com.elblasy.m_elblasy.psedv2.adapters.ListOFProjects;

import java.util.ArrayList;
import java.util.List;

public class ItemsForCells {
    private int titleImage;
    private int contentImage;
    private Bitmap image;
    private ArrayList<ArrayList<ProjectsList>> listOFProjects = new ArrayList<>(7);

    public ItemsForCells(){

    }
    public ItemsForCells(ArrayList<ArrayList<ProjectsList>> listOFProjects) {
        this.listOFProjects = listOFProjects;
    }

    public ItemsForCells(int image) {
        this.titleImage = image;
    }


    public int getContentImage() {
        return contentImage;
    }

    public ItemsForCells setContentImage(int contentImage) {
        this.contentImage = contentImage;
        return null;
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

    public int getTitleImage() {
        return titleImage;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

     public static ArrayList<ItemsForCells> getTitleList() {
        ArrayList<ItemsForCells> items = new ArrayList<>();
        items.add(new ItemsForCells(R.drawable.computer));
        items.add(new ItemsForCells(R.drawable.communication));
        items.add(new ItemsForCells(R.drawable.power));
         items.add(new ItemsForCells(R.drawable.arch));
         items.add(new ItemsForCells(R.drawable.civil));
         items.add(new ItemsForCells(R.drawable.production));
        items.add(new ItemsForCells(R.drawable.mechanic));
        items.add(new ItemsForCells(R.drawable.marin));
         items.add(new ItemsForCells(R.drawable.gas));
         items.add(new ItemsForCells(R.drawable.chemical));
         return items;
    }

    public static ArrayList<ItemsForCells> getContentList() {
        ArrayList<ItemsForCells> items = new ArrayList<>();
        items.add(new ItemsForCells().setContentImage(R.drawable.computerin));
        items.add(new ItemsForCells().setContentImage(R.drawable.communicationin));
        items.add(new ItemsForCells().setContentImage(R.drawable.powerin));
        items.add(new ItemsForCells().setContentImage(R.drawable.archin));
        items.add(new ItemsForCells().setContentImage(R.drawable.civilin));
        items.add(new ItemsForCells().setContentImage(R.drawable.prodin));
        items.add(new ItemsForCells().setContentImage(R.drawable.mechanicin));
        items.add(new ItemsForCells().setContentImage(R.drawable.marinein));
        items.add(new ItemsForCells().setContentImage(R.drawable.gasin));
        items.add(new ItemsForCells().setContentImage(R.drawable.chemistryin));
        return items;
    }
}
