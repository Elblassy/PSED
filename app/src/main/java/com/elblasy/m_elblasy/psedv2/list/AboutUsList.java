package com.elblasy.m_elblasy.psedv2.list;


import com.elblasy.m_elblasy.psedv2.R;

import java.util.ArrayList;
import java.util.List;

public class AboutUsList {

    private String nameOfLeader;
    private int leader;
    private int bg;
    private int des;
    private String team;

    public AboutUsList() {
    }

    public AboutUsList(String nameOfLeader, int leader, int bg, int des, String team) {
        this.nameOfLeader = nameOfLeader;
        this.leader = leader;
        this.bg = bg;
        this.des = des;
        this.team = team;
    }

    public String getNameOfLeader() {
        return nameOfLeader;
    }

    public void setNameOfLeader(String nameOfLeader) {
        this.nameOfLeader = nameOfLeader;
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<AboutUsList> getlist() {
        ArrayList<AboutUsList> aboutUsLists = new ArrayList<>();

        aboutUsLists.add(new AboutUsList("Dr/Heba", R.drawable.drheba,
                R.drawable.bgteam2, R.string.dr_heba, "Leader"));
        aboutUsLists.add(new AboutUsList("Muhammad Nabil", R.drawable.nabit,
                R.drawable.bgteam8, R.string.design, "Design"));
        aboutUsLists.add(new AboutUsList("Rwan Muhammad", R.drawable.media,
                R.drawable.bgteam1, R.string.marketing, "Media"));
        aboutUsLists.add(new AboutUsList("Muhammad Khodir", R.drawable.sales,
                R.drawable.bgteam3, R.string.procurement, "Financial"));
        aboutUsLists.add(new AboutUsList("Ahmed Moussa", R.drawable.mousa,
                R.drawable.bgteam4, R.string.PR, "PR"));
        aboutUsLists.add(new AboutUsList("Lobna Sami", R.drawable.lobnasamileadersec,
                R.drawable.bgteam5, R.string.secretary, "Secretary"));
        aboutUsLists.add(new AboutUsList("Shrouk Ashraf", R.drawable.teams,
                R.drawable.bgteam8, R.string.Projects, "Team"));
        aboutUsLists.add(new AboutUsList("Sherif Elmahdy", R.drawable.fr,
                R.drawable.bgteam2, R.string.Fund, "FR"));

        return aboutUsLists;
    }
}
