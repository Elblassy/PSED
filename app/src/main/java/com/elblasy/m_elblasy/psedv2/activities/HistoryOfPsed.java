package com.elblasy.m_elblasy.psedv2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;

import com.bumptech.glide.Glide;
import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.adapters.HistoryAdapter;

import java.util.ArrayList;

import com.elblasy.m_elblasy.psedv2.adapters.HistoryAdapter;

public class HistoryOfPsed extends AppCompatActivity {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(com.elblasy.m_elblasy.psedv2.R.layout.activity_history_of_psed);

        getList();



        initAnimation();

        getWindow().setAllowEnterTransitionOverlap(false);

    }

    private void getList(){
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.nineout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.tenout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.elevout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.twelout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.theout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.fourout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.fiveout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.sixout);
        list.add(com.elblasy.m_elblasy.psedv2.R.drawable.seveout);

        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.ninein);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.tenin);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.elevin);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.tewin);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.threein);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.fourin);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.fivein);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.sixin);
        image.add(com.elblasy.m_elblasy.psedv2.R.drawable.sevenin);

        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2009));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2010));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2011));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2012));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2013));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2014));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2015));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2016));
        text.add(getResources().getString(com.elblasy.m_elblasy.psedv2.R.string.psed_2017));

        initRecyclerView();
    }

    private void initAnimation(){

        Slide enterTransition = new Slide();
        enterTransition.setSlideEdge(Gravity.END);
        enterTransition.setDuration(getResources().getInteger(com.elblasy.m_elblasy.psedv2.R.integer.anim_duration_very_long));
        enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
        getWindow().setEnterTransition(enterTransition);
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(com.elblasy.m_elblasy.psedv2.R.id.history_of_psed);
        HistoryAdapter historyAdapter = new HistoryAdapter(this,list , image , text);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(historyAdapter);
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
