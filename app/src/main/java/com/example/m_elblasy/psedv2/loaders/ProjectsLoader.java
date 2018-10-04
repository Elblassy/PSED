package com.example.m_elblasy.psedv2.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import com.example.m_elblasy.psedv2.list.ItemsForCells;
import com.example.m_elblasy.psedv2.loading_data.ProjectsData;

import java.util.List;

public class ProjectsLoader extends AsyncTaskLoader<List<ItemsForCells>> {

    private static final String LOG_TAG = ProjectsLoader.class.getName();
    private String mUrl;

    public ProjectsLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<ItemsForCells> loadInBackground() {


        List<ItemsForCells> projects = ProjectsData.fetchProjectsData(mUrl);
        Log.i(LOG_TAG, "loading in background");
        return projects;
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }
}
