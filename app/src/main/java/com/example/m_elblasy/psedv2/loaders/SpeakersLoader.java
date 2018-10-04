package com.example.m_elblasy.psedv2.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.example.m_elblasy.psedv2.list.ModelOfData;
import com.example.m_elblasy.psedv2.loading_data.SpeakersData;

import java.util.List;

public class SpeakersLoader extends AsyncTaskLoader<List<ModelOfData>> {

    private static final String LOG_TAG = SpeakersLoader.class.getName();
    private String mUrl;

    public SpeakersLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<ModelOfData> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<ModelOfData> modelOfData = SpeakersData.fetchSpeakersData(mUrl);
        Log.i(LOG_TAG , "loading in background");
        return modelOfData;
    }


}
