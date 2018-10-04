package com.example.m_elblasy.psedv2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.Window;

import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.adapters.AboutUsAdapter;
import com.example.m_elblasy.psedv2.list.GrideList;

import java.util.ArrayList;
import java.util.List;

public class AboutUs extends AppCompatActivity {

    List<List<GrideList>> lists ;
    GrideList grideList = new GrideList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        lists = new ArrayList<>();


        getLists();

        initAnimation();

        getWindow().setAllowEnterTransitionOverlap(false);

    }

    private void getLists(){
        lists.add(grideList.listOfDesigner());
        lists.add(grideList.listOfMarket());
        lists.add(grideList.listOfProduction());
        lists.add(grideList.listOfRelation());
        lists.add(grideList.listOfSecrtary());

        initRecyclerView();
    }

    private void initAnimation(){

        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setEnterTransition(enterTransition);
    }

    private void initRecyclerView() {


        RecyclerView recyclerView = findViewById(R.id.list_item_aboutus);
        AboutUsAdapter srva = new AboutUsAdapter(this,lists);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(srva);
    }


}
