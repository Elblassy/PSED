package com.elblasy.m_elblasy.psedv2.list;

import com.elblasy.m_elblasy.psedv2.R;

import java.util.ArrayList;
import java.util.List;

public class GrideList {

    private int image;
    private String name;


    public GrideList() {

    }

    public GrideList(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<GrideList> listOfLeaders() {
        ArrayList<GrideList> items = new ArrayList<>();

        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design11, "Muhammad Nabil"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.shroukashraf, "Shrouk Ashraf"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.askr, "Askr"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.rowan, "rowan mohamed"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.lobna, "Lobna samy"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sherif, "Sherif"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.moussa, "Mousa"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.elsadr1, "elsadr"));


        return items;
    }

    public List<GrideList> listOfDesigner() {
        ArrayList<GrideList> items = new ArrayList<>();

        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design12, "Mostafa Essam"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design3, "Muhammad Elblasy"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design1, "Ali"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design2, "Ahmed Oraby"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design4, "Hamooda"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design5, "Marawan Bakr"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design6, "Mowafy"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design7, "Reham"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design8, "Yasmin"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design9, "Noha"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design10, "El nahala"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.design14, "omar emad"));



        return items;
    }

    public List<GrideList> listOfSecrtary() {
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec2, "Ahmed Azzam"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec3, "Salma Yasser"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec4, "Mariam Hazem"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec5, "Hager Helmy"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec6, "Essra"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec7, "Toka Taha"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec8, "Muhammad Heba"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec9, "Amr Akram"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sec10, "Mazen"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.noora, "Noora"));


        return items;
    }

    public List<GrideList> listOfMedia() {
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media2, "Mariam Elsehrawy"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media3, "Shrouk"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media4, "Alaa Soliman"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media5, "Amr Gohar"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media6, "Mohab"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media7, "Mariez"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media8, "Noran Elgayar"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media9, "Muhammad Elrefay"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.media10, "Reem Medhat"));


        return items;
    }

    public List<GrideList> listOfRelation() {
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pr1, "Yasmin Elkatanty"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pr2, "Reem Hassan"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pr3, "Ezz"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pr4, "Shimaa Moftah"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pr5, "Meram"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pr6, "Alaa Adel"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pr7, "henazada"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.sodfa, "Sodfa Diab"));


        return items;
    }

    public List<GrideList> listOfProduction() {
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.abdulmenaamp, "Abdekmonem Sharaf"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.ahmedsamirp, "Ahmed Samir Sherif"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.mohammedsamip, "Muhammad Samy"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.omaralaa, "Omar Hamed"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pu2, "Hossam"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pu4, "Muhammad Mamdouh"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.pu5, "Kamal"));


        return items;
    }

    public List<GrideList> listOfTeam() {
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams1, "Amr Elzanaty"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams2, "Huda Abdel-ghany"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams3, "Omar elsaka"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams4, ""));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams5, "Muhammad Ashraf"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams6, "Shereef"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams7, "Muhammad nasser"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.teams8, "Abdulrahaman Sultan"));


        return items;
    }

    public List<GrideList> listOfFounders() {
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund1, "Hala Adel"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund2, "Ahmed Alaa"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund3, "Dina Eloarabany"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund4, "Elhadidy"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund5, "Muhammad Eyad"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund6, "hager"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund7, "Hazem Leheta"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund8, "Ahmed Kazlak"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund9, "Omar Hossam"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund10, "Mahmoud Mohssen"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund11, "Rawan Elsady"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.fund12, "Muhammad Khalil"));
        items.add(new GrideList(com.elblasy.m_elblasy.psedv2.R.drawable.reemmoahmmedfr, "Reem Mohamed"));

        return items;
    }
}
