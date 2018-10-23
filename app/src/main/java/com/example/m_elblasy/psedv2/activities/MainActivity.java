package com.example.m_elblasy.psedv2.activities;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.adapters.StaggeredRecycleViewAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private BottomSheetDialog myDialog;
    private TextView view;
    long diff;
    long oldLong;
    long NewLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.date);


        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
        String NewTime = "05.11.2018, 9:00";//Timer date 2
        Date oldDate, newDate;
        try {
            oldDate = Calendar.getInstance().getTime();
            newDate = formatter.parse(NewTime);
            oldLong = oldDate.getTime();
            NewLong = newDate.getTime();
            diff = NewLong - oldLong;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MyCount counter = new MyCount(diff, 1000);
        counter.start();


        myCustomAlertDialog();

        initImageBitmaps();
        setupWindowAnimations();

    }

    // countdowntimer is an abstract class, so extend it and fill in methods
    public class MyCount extends CountDownTimer {
        MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            view.setText("Done!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = (TimeUnit.MILLISECONDS.toDays(millis)) + " Days "
                    + (TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)) + ":")
                    + (TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)) + ":"
                    + (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
            view.setText(/*context.getString(R.string.ends_in) + " " +*/ hms);
        }
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


        mImageUrls.add(R.drawable.psed);
        mNames.add("Old PSED");


        mImageUrls.add(R.drawable.projects);
        mNames.add(" ");

        mImageUrls.add(R.drawable.speakers);
        mNames.add("Speakers");


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
                else if (position == 2)
                    pos = 2;
                else
                    pos = position % 5 == 0 ? 2 : 1;

                return pos;
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(srva);
    }

    private void myCustomAlertDialog() {

        //implement custom dialog
        myDialog = new BottomSheetDialog(this);

        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myDialog.setContentView(R.layout.sponsers);
        Button skip = myDialog.findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;

        myDialog.show();
    }

}
