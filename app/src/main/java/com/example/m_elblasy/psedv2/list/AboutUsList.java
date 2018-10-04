package com.example.m_elblasy.psedv2.list;

import java.util.ArrayList;

public class AboutUsList {

    private ArrayList<ArrayList<GrideList>> lists;
    private String nameOfLeader;
    private int leader;

    public AboutUsList(ArrayList<ArrayList<GrideList>> lists, int leader,String nameOfLeader) {
        this.lists = lists;
        this.leader = leader;
        this.nameOfLeader = nameOfLeader;
    }

    public ArrayList<ArrayList<GrideList>> getLists() {
        return lists;
    }

    public int getLeader() {
        return leader;
    }

    public String getNameOfLeader() {
        return nameOfLeader;
    }
}
