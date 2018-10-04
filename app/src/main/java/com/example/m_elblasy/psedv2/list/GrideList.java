package com.example.m_elblasy.psedv2.list;

import com.example.m_elblasy.psedv2.R;

import java.util.ArrayList;
import java.util.List;

public class GrideList {

    private int image ;
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

    public List<GrideList> listOfDesigner(){
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(R.drawable.d1,"elkholany"));
        items.add(new GrideList(R.drawable.d2,"wwwqeq"));
        items.add(new GrideList(R.drawable.d4,"yweywe"));
        items.add(new GrideList(R.drawable.d5,"yery"));
        items.add(new GrideList(R.drawable.d6,"elkholany"));
        items.add(new GrideList(R.drawable.d7,"yrwey"));
        items.add(new GrideList(R.drawable.d8,"elkholany"));
        items.add(new GrideList(R.drawable.d9,"eqewqewq"));
        items.add(new GrideList(R.drawable.d10,"elkholany"));
        items.add(new GrideList(R.drawable.d11,"jvfjf"));

        return items;
    }

    public List<GrideList> listOfSecrtary(){
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(R.drawable.s1,"yasmeen"));
        items.add(new GrideList(R.drawable.s2,"fsafsaf"));
        items.add(new GrideList(R.drawable.s4,"yqtqwtwq"));
        items.add(new GrideList(R.drawable.s5,"tttteteq"));
        items.add(new GrideList(R.drawable.s6,"hgfhj"));
        items.add(new GrideList(R.drawable.s3,"mbcmb"));
        items.add(new GrideList(R.drawable.s8,"jfdjd"));
        items.add(new GrideList(R.drawable.s7,"yeryew"));

        return items;
    }
    public List<GrideList> listOfMarket(){
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(R.drawable.m1,"rwqrqwr"));
        items.add(new GrideList(R.drawable.m2,"safasfqw"));
        items.add(new GrideList(R.drawable.m4,"elkholany"));
        items.add(new GrideList(R.drawable.m5,"4124124"));
        items.add(new GrideList(R.drawable.m6,"fasasfas"));
        items.add(new GrideList(R.drawable.m7,"elkholany"));
        items.add(new GrideList(R.drawable.m8,"elkholany"));
        items.add(new GrideList(R.drawable.m12,"uyrue"));
        items.add(new GrideList(R.drawable.m10,"jfjytf"));
        items.add(new GrideList(R.drawable.m11,"ouyto"));

        return items;
    }
    public List<GrideList> listOfRelation(){
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(R.drawable.r1,"yukiyti"));
        items.add(new GrideList(R.drawable.r2,"ewqewqeqw"));
        items.add(new GrideList(R.drawable.r4,"fsafasf"));
        items.add(new GrideList(R.drawable.r3,"weqeqwe"));

        return items;
    }
    public List<GrideList> listOfProduction(){
        ArrayList<GrideList> items = new ArrayList<>();
        items.add(new GrideList(R.drawable.p1,"lhgkfhgk"));
        items.add(new GrideList(R.drawable.p2,"hcncv"));
        items.add(new GrideList(R.drawable.p4,"yeyet"));
        items.add(new GrideList(R.drawable.p5,"kgkmb"));
        items.add(new GrideList(R.drawable.p6,"hsdgsge"));
        items.add(new GrideList(R.drawable.p3,"jhgfjhjhd"));

        return items;
    }
}
