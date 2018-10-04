package com.example.m_elblasy.psedv2.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;


import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.adapters.StaggeredRecycleViewAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();

    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.date);
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd ");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);



        initImageBitmaps();
        setupWindowAnimations();

    }


    private void setupWindowAnimations() {

        // Re-enter transition is executed when returning back to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.START); // Use START if using right - to - left locale
        slideTransition.setDuration(350);

        getWindow().setReenterTransition(slideTransition);  // When MainActivity Re-enter the Screen
        getWindow().setExitTransition(slideTransition);     // When MainActivity Exits the Screen

        // For overlap of Re Entering Activity - MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);
    }




    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.anniversary);
        mNames.add("What is PSED ?");

        mImageUrls.add(R.drawable.psed);
        mNames.add("History");


        mImageUrls.add(R.drawable.speakers);
        mNames.add("Speakers");


        mImageUrls.add(R.drawable.projects);
        mNames.add(" ");

        mImageUrls.add(R.drawable.ajenda);
        mNames.add("Ajenda");


        mImageUrls.add(R.drawable.aboutus);
        mNames.add(" ");



        initRecyclerView();

    }



    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: initializing staggered recyclerview.");

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        StaggeredRecycleViewAdapter srva = new StaggeredRecycleViewAdapter(this, mNames, mImageUrls);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, NUM_COLUMNS, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int pos;
                if (position == 0)
                    pos = 1;
                else if(position == 2)
                    pos = 2;
                else
                   pos = position % 5 == 0 ? 2 : 1;

                return pos;
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(srva);
    }

}
