package com.example.m_elblasy.psedv2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.Window;

import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.adapters.HistoryAdapter;

import java.util.ArrayList;

public class HistoryOfPsed extends AppCompatActivity {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_of_psed);

        getList();



        initAnimation();

        getWindow().setAllowEnterTransitionOverlap(false);

    }

    private void getList(){
        list.add(R.drawable.nineout);
        list.add(R.drawable.tenout);
        list.add(R.drawable.elevout);
        list.add(R.drawable.twelout);
        list.add(R.drawable.theout);
        list.add(R.drawable.fourout);
        list.add(R.drawable.fiveout);
        list.add(R.drawable.sixout);
        list.add(R.drawable.seveout);

        image.add(R.drawable.ninein);
        image.add(R.drawable.tenin);
        image.add(R.drawable.sixin);
        image.add(R.drawable.fifein);

        text.add(getResources().getString(R.string.psed_2009));
        text.add(getResources().getString(R.string.psed_2010));
        text.add(getResources().getString(R.string.psed_2011));

        initRecyclerView();
    }

    private void initAnimation(){

        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setEnterTransition(enterTransition);
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.history_of_psed);
        HistoryAdapter historyAdapter = new HistoryAdapter(this,list , image , text);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(historyAdapter);
    }


}