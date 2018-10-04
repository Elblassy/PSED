package com.example.m_elblasy.psedv2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.m_elblasy.psedv2.R;

public class ContentOfHistory extends AppCompatActivity {

    ImageView image;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_of_history);

        image = findViewById(R.id.image_content_of_history);
        text = findViewById(R.id.text_of_history);

        Intent intent = getIntent();

        int image1 = intent.getIntExtra("image",0);
        String text1 = intent.getStringExtra("text");

        image.setImageResource(image1);
        text.setText(String.valueOf(text1));


        initAnimation();

        getWindow().setAllowEnterTransitionOverlap(false);
    }

    //set Animation
    private void initAnimation() {

        Slide enterTransition = new Slide();
        enterTransition.setSlideEdge(Gravity.END);
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
        getWindow().setEnterTransition(enterTransition);
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
    protected void onStop() {
        super.onStop();
        Glide.get(this).clearMemory();
    }
}
