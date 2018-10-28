package com.elblasy.m_elblasy.psedv2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;

import com.bumptech.glide.Glide;
import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.adapters.AboutUsAdapter;
import com.elblasy.m_elblasy.psedv2.list.AboutUsList;
import com.elblasy.m_elblasy.psedv2.list.GrideList;

import java.util.ArrayList;
import java.util.List;

public class AboutUs extends AppCompatActivity {

    List<List<GrideList>> lists;
    List<AboutUsList> aboutUs;
    GrideList grideList = new GrideList();
    AboutUsList aboutUsList = new AboutUsList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        lists = new ArrayList<>();
        aboutUs = aboutUsList.getlist();


        getLists();

        initAnimation();

        getWindow().setAllowEnterTransitionOverlap(false);

    }

    private void getLists() {
        lists.add(grideList.listOfLeaders());
        lists.add(grideList.listOfDesigner());
        lists.add(grideList.listOfMedia());
        lists.add(grideList.listOfProduction());
        lists.add(grideList.listOfRelation());
        lists.add(grideList.listOfSecrtary());
        lists.add(grideList.listOfTeam());
        lists.add(grideList.listOfFounders());

        initRecyclerView();
    }

    private void initAnimation() {

        Slide enterTransition = new Slide();
        enterTransition.setSlideEdge(Gravity.END);
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
        getWindow().setEnterTransition(enterTransition);
    }

    private void initRecyclerView() {


        RecyclerView recyclerView = findViewById(R.id.list_item_aboutus);
        AboutUsAdapter srva = new AboutUsAdapter(this, lists,aboutUs);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(srva);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Glide.get(this).clearMemory();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Glide.get(this).clearMemory();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Glide.get(this).clearMemory();
    }
}
