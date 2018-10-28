package com.elblasy.m_elblasy.psedv2.activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elblasy.m_elblasy.psedv2.QueryUtils;
import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.adapters.StaggeredRecycleViewAdapter;
import com.elblasy.m_elblasy.psedv2.list.Registration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String URL = "https://elblasypsed.000webhostapp.com/id.json";
    private int idCount = 0;
    private static final int NUM_COLUMNS = 2;

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private BottomSheetDialog myDialog;
    private BottomSheetDialog register;
    private TextView view;
    long diff;
    long oldLong;
    long NewLong;
    DatabaseReference storage, storage2;
    EditText name, email, number;
    NetworkInfo networkInfo;
    TextView id_counter;
    SimpleDateFormat formatter;
    boolean generate = false;
    int code = randInt(9000, 10000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        view = findViewById(R.id.date);

        //Get Firebase instance
        storage = FirebaseDatabase.getInstance().getReference("Registration");
        storage2 = FirebaseDatabase.getInstance().getReference("id");

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MainActivity.this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                Log.e("newToken", newToken);

            }
        });

        id_counter = (TextView) findViewById(R.id.id_counter);


        formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
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


        SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = preferences.getBoolean("firstStart", true);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        networkInfo = connMgr.getActiveNetworkInfo();


        if (firstStart) {
            register();
        } else
            myCustomAlertDialog();


        initImageBitmaps();
        setupWindowAnimations();


        ImageView twitter = (ImageView) findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://twitter.com/PSEDNews";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        ImageView fb = (ImageView) findViewById(R.id.face);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/psedpage/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ImageView insta = (ImageView) findViewById(R.id.insta);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/portsaidengineeringday/?hl=en";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

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
        mNames.add("Projects");

        mImageUrls.add(R.drawable.speakers);
        mNames.add("Speakers");


        mImageUrls.add(R.drawable.ajenda);
        mNames.add("Agenda");


        mImageUrls.add(R.drawable.aboutus);
        mNames.add("Team");


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

    private void register() {
        //implement custom dialog
        register = new BottomSheetDialog(this);

        register.requestWindowFeature(Window.FEATURE_NO_TITLE);
        register.setContentView(R.layout.registration);
        register.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        register.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        register.setCanceledOnTouchOutside(false);

        final Button registeration = register.findViewById(R.id.register);
        name = register.findViewById(R.id.name);
        email = register.findViewById(R.id.email);
        number = register.findViewById(R.id.number);


        registeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String mName = name.getText().toString().trim();
                final String mEmail = email.getText().toString().trim();
                final String mNumber = number.getText().toString().trim();

                if (TextUtils.isEmpty(mName)) {
                    Toast.makeText(getApplicationContext(), "Enter your name!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(mEmail)) {
                    Toast.makeText(getApplicationContext(), "Enter your email!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(mNumber)) {
                    Toast.makeText(getApplicationContext(), "Enter your phone number!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (mNumber.length() < 11) {
                    Toast.makeText(getApplicationContext(), "Valid number!", Toast.LENGTH_LONG).show();
                    return;
                }


                if (networkInfo != null && networkInfo.isConnected()) {

                    storage.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            String s1 = dataSnapshot.getKey();
                            if (s1 != null)
                                generate = !s1.equals(String.valueOf(code));
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                    Toast.makeText(MainActivity.this, "Successful Registration", Toast.LENGTH_LONG).show();


                    if (generate) {
                        Registration registration = new Registration(String.valueOf(code), mName, mEmail, mNumber);
                        String currentDateandTime = formatter.format(new Date());
                        id_counter.setText("B-" + String.valueOf(code) + "--" + currentDateandTime);
                        storage.child(String.valueOf(code)).setValue(registration);
                    }else
                    {
                        code = randInt(9000, 10000);
                        Registration registration = new Registration(String.valueOf(code), mName, mEmail, mNumber);
                        String currentDateandTime = formatter.format(new Date());
                        id_counter.setText("B-" + String.valueOf(code) + "--" + currentDateandTime);
                        storage.child(String.valueOf(code)).setValue(registration);
                    }
                    SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();
                    register.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "please connect with Internet", Toast.LENGTH_LONG).show();

                }


            }
        });


        register.show();
    }

    private static int randInt(int min, int max) {

        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
