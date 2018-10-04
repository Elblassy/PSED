package com.example.m_elblasy.psedv2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.adapters.AjendaAdapter;
import com.example.m_elblasy.psedv2.adapters.StaggeredRecycleViewAdapter;

import java.util.ArrayList;

public class Ajenda extends AppCompatActivity {

    private ArrayList<String> title;
    private ArrayList<String> time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajenda);

        time = new ArrayList<>();
        title = new ArrayList<>();

        getList();
    }

    private void getList(){

        time.add("9:00");
        title.add("start of day");

        time.add("10:00");
        title.add("Spaeker : ahmed elblasy");

        time.add("11:00");
        title.add("fsanifusau  fabsoif asf fbsail");

        time.add("12:20");
        title.add("gdsaga asfads sdaf");

        time.add("14:30");
        title.add("fafds afsf adf a fda");

        time.add("16:45");
        title.add("break");

        time.add("18:00");
        title.add("ending day");

        initRecyclerView();

    }

    private void initRecyclerView() {


        RecyclerView recyclerView = findViewById(R.id.ajenda_recycler);
        AjendaAdapter ajendaAdapter = new AjendaAdapter( title, time);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(ajendaAdapter);
    }


}
