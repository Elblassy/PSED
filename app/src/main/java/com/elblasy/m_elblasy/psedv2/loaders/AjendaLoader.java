package com.elblasy.m_elblasy.psedv2.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.elblasy.m_elblasy.psedv2.list.AjendaList;
import com.elblasy.m_elblasy.psedv2.loading_data.AjendaData;

import java.util.List;

public class AjendaLoader extends AsyncTaskLoader<List<AjendaList>> {

    private static final String LOG_TAG = AjendaLoader.class.getName();
    private String mUrl;

    public AjendaLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    @Override
    public List<AjendaList> loadInBackground() {

        List<AjendaList> ajendaLists = AjendaData.fetchAjendaData(mUrl);
        Log.i(LOG_TAG, "loading in background");

        return ajendaLists;
    }
}
