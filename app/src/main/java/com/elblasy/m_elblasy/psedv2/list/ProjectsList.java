package com.elblasy.m_elblasy.psedv2.list;

import android.graphics.Bitmap;


public class ProjectsList {
    private Bitmap imageOfProject;
    private String dis;

    public ProjectsList(Bitmap imageOfProject, String dis) {
        this.imageOfProject = imageOfProject;
        this.dis = dis;
    }


    public Bitmap getImageOfProject() {
        return imageOfProject;
    }

    public String getDis() {
        return dis;
    }


/* public static ArrayList<ProjectsList> getList() {
        ArrayList<ProjectsList> items = new ArrayList<>();
        items.add(new ProjectsList(R.drawable.computer,"fsanjklfnaslfkbsafkbsa ,fabsf"));
        items.add(new ProjectsList(R.drawable.communication,"fsanjklfnaslfkbsafkbsa ,fabsf"));
        items.add(new ProjectsList(R.drawable.civil,"fsanjklfnaslfkbsafkbsa ,fabsf"));
        items.add(new ProjectsList(R.drawable.power,"fsanjklfnaslfkbsafkbsa ,fabsf"));
        items.add(new ProjectsList(R.drawable.mechanic,"fsanjklfnaslfkbsafkbsa ,fabsf"));
        items.add(new ProjectsList(R.drawable.marine,"fsanjklfnaslfkbsafkbsa ,fabsf"));
        items.add(new ProjectsList(R.drawable.arch,"fsanjklfnaslfkbsafkbsa ,fabsf"));
        return items;
    }*/
}
