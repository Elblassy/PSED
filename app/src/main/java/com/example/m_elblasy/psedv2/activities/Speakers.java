package com.example.m_elblasy.psedv2.activities;

import android.app.Dialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.m_elblasy.psedv2.CustomItemClickListener;
import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.list.Questions;
import com.example.m_elblasy.psedv2.loaders.SpeakersLoader;
import com.example.m_elblasy.psedv2.adapters.SpeakersAdapter;
import com.example.m_elblasy.psedv2.list.ModelOfData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;


public class Speakers extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<ModelOfData>> {

    private static final String URL_JSON_SPEAKERS = "https://elblasypsed.000webhostapp.com/Speakers.json";
    private RecyclerView mRecyclerView;
    private SpeakersAdapter mAdapter;
    private static final int SPEAKER_LOADER_ID = 0;
    ArrayList<ModelOfData> data;
    private TextView mEmptyStateTextView;
    TextView disc, name;
    ImageView imageOfSpeaker, imageOfTitle;
    LoaderManager loaderManager;
    Animation fadeIn, fadeIn2;
    private static final String TAG = "Speakers";
    private Dialog myDialog;
    EditText speakerName;
    EditText question;
    Button button;
    ProgressBar progressBar;
    DatabaseReference storage;
    private ImageView emptyView,noInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        //Firebase setting
        storage = FirebaseDatabase.getInstance().getReference("Speakers");
        emptyView = (ImageView)findViewById(R.id.emptyview);
        noInternet = (ImageView)findViewById(R.id.noInternetConnection);

        //speakers info
        disc = (TextView) findViewById(R.id.dis);
        name = (TextView) findViewById(R.id.nameofspeaker);
        imageOfSpeaker = (ImageView) findViewById(R.id.imageofspeaker);
        imageOfTitle = (ImageView) findViewById(R.id.title_image);
        progressBar = (ProgressBar) findViewById(R.id.progressbar_speaker);
        data = new ArrayList<>();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCustomAlertDialog();
            }
        });

        //initialize recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_speakers);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(false);

        //setup animation
        fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(600);
        fadeIn.setFillAfter(true);

        fadeIn2 = new AlphaAnimation(0.0f, 1.0f);
        fadeIn2.setDuration(600);
        fadeIn2.setFillAfter(true);



        //adapter and item selected
        mAdapter = new SpeakersAdapter(data, this, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                String dis = data.get(position).getDis();
                disc.setText(dis);
                name.setText(data.get(position).getName());
                imageOfSpeaker.setImageBitmap(data.get(position).getImage());
                imageOfSpeaker.setScaleY(2.5f);

                //setup animation hasn't complete yet
                if (data.indexOf(data.get(position)) == position) {
                    Log.i(TAG, "speakers" + position);
                    Log.i(TAG, "speakers2" + data.get(position).getImage());
                    name.startAnimation(fadeIn);
                    disc.startAnimation(fadeIn);
                    imageOfSpeaker.startAnimation(fadeIn);
                }
                name.setVisibility(View.VISIBLE);
                imageOfSpeaker.setVisibility(View.VISIBLE);
                disc.setVisibility(View.VISIBLE);


            }
        });

        /*Bundle extra = getIntent().getExtras();
        String urlImage = extra.getString("image");*/
        Glide.with(this)
                .load(R.drawable.speakers)
                .into(imageOfTitle);


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            getLoaderManager().initLoader(SPEAKER_LOADER_ID, null, this);
        }else {
            progressBar.setVisibility(View.GONE);
            noInternet.setVisibility(View.VISIBLE);
        }

        initAnimation();

        getWindow().setAllowEnterTransitionOverlap(false);

    }




    @Override
    public Loader<List<ModelOfData>> onCreateLoader(int i, Bundle bundle) {
        return new SpeakersLoader(this, URL_JSON_SPEAKERS);
    }

    @Override
    public void onLoadFinished(Loader<List<ModelOfData>> loader, List<ModelOfData> modelOfData) {

        progressBar.setVisibility(View.GONE);
        if (modelOfData != null && !modelOfData.isEmpty()) {
            data.clear();
            data.addAll(modelOfData);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else {
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<ModelOfData>> loader) {
        loader.forceLoad();
    }

    private void myCustomAlertDialog() {

        //implement custom dialog
        myDialog = new Dialog(this);
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myDialog.setContentView(R.layout.speak_to_speaker);

        //implement  element in dialog
        speakerName = myDialog.findViewById(R.id.edit_speaker_name);
        question = myDialog.findViewById(R.id.edit_question);
        button = myDialog.findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();

            }
        });


        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;

        myDialog.show();
    }

    //firebase
    private void send() {

        //get data
        String mSpeakerNmae = speakerName.getText().toString();
        String mQuestion = question.getText().toString();
        if (!mSpeakerNmae.isEmpty() && !mQuestion.isEmpty()) {
            Questions questions = new Questions(mSpeakerNmae, mQuestion);
            String id = storage.child("speaker").push().getKey();            storage.child(id).setValue(questions);
            myDialog.dismiss();
            Toast.makeText(this, "Question sent...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Name of speaker or question is empty ", Toast.LENGTH_LONG).show();
        }
    }

    //set Animation
    private void initAnimation() {

        Slide enterTransition = new Slide();
        enterTransition.setSlideEdge(Gravity.RIGHT);
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
        getWindow().setEnterTransition(enterTransition);
    }

}
