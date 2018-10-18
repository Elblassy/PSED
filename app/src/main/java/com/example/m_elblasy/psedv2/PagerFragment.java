package com.example.m_elblasy.psedv2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public final  class PagerFragment extends Fragment {

    private static final String KEY_CONTENT = "PagerFragment:";
    int imageSource;

    @SuppressLint("ValidFragment")
    public PagerFragment(int imageSource) {
        this.imageSource = imageSource;

    }

    public PagerFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            imageSource = savedInstanceState.getInt(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.indicatorpage, null);
        ImageView image = (ImageView) root.findViewById(R.id.pagerImage);
        image.setImageResource(imageSource);
        setRetainInstance(true);
        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTENT, imageSource);
    }
}
