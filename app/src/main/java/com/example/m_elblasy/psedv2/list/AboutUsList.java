package com.example.m_elblasy.psedv2.list;


import com.example.m_elblasy.psedv2.R;

import java.util.ArrayList;
import java.util.List;

public class AboutUsList {

    private String nameOfLeader;
    private int leader;
    private int bg;
    private String des;
    private String team;

    public AboutUsList() {
    }

    public AboutUsList(String nameOfLeader, int leader, int bg, String des, String team) {
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
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

        aboutUsLists.add(new AboutUsList("Muhammad Nabil", R.drawable.lobnasamileadersec,
                R.drawable.bgteam8, "the afasf fsaffa", "Design"));
        aboutUsLists.add(new AboutUsList("Muhammad Hassan Shehata", R.drawable.lobnasamileadersec,
                R.drawable.bgteam1, "the bzewy fsaffa", "Media"));
        aboutUsLists.add(new AboutUsList("Muhammad Khodir", R.drawable.elsadr,
                R.drawable.bgteam3, "the afasf yewyw", "Financial"));
        aboutUsLists.add(new AboutUsList("Muhammad Moussa", R.drawable.mousa,
                R.drawable.bgteam4, "the afrqwrasf fsaffa", "PR"));
        aboutUsLists.add(new AboutUsList("Lobna Sami", R.drawable.lobnasamileadersec,
                R.drawable.bgteam5, "the afasf eqqeq", "Secretary"));
        aboutUsLists.add(new AboutUsList("Shrouk Ashraf", R.drawable.lobnasamileadersec,
                R.drawable.bgteam2, "the aahjtrjk fsaffa", "Team"));
        aboutUsLists.add(new AboutUsList("Sherif Elmahdy", R.drawable.lobnasamileadersec,
                R.drawable.bgteam2, "the aahjtrjk fsaffa", "FR"));

        return aboutUsLists;
    }
}
