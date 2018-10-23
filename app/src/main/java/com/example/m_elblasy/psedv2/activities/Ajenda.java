package com.example.m_elblasy.psedv2.activities;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.adapters.AjendaAdapter;
import com.example.m_elblasy.psedv2.list.AjendaList;
import com.example.m_elblasy.psedv2.loaders.AjendaLoader;

import java.util.ArrayList;
import java.util.List;

public class Ajenda extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<AjendaList>> {

    private static final String URL_JSON_AJENDA = "https://elblasypsed.000webhostapp.com/ajenda.json";
    private static final int AJENDA_LOADER_ID = 2;
    private ArrayList<AjendaList> list;
    AjendaAdapter ajendaAdapter;
    RecyclerView recyclerView;
    private ImageView emptyView,noInternet;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajenda);

        list = new ArrayList<>();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        emptyView = (ImageView)findViewById(R.id.emptyview);
        noInternet = (ImageView)findViewById(R.id.noInternetConnection);

        recyclerView = findViewById(R.id.ajenda_recycler);
        ajendaAdapter = new AjendaAdapter(list);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 0));

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            getLoaderManager().initLoader(AJENDA_LOADER_ID, null, this);
        }else {
            progressBar.setVisibility(View.GONE);
            noInternet.setVisibility(View.VISIBLE);
        }

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
    public Loader<List<AjendaList>> onCreateLoader(int i, Bundle bundle) {
        return new AjendaLoader(this, URL_JSON_AJENDA);
    }

    @Override
    public void onLoadFinished(Loader<List<AjendaList>> loader, List<AjendaList> ajendaLists) {

        progressBar.setVisibility(View.GONE);
        if (ajendaLists != null && !ajendaLists.isEmpty()) {
            list.clear();
            list.addAll(ajendaLists);
            recyclerView.setAdapter(ajendaAdapter);
            ajendaAdapter.notifyDataSetChanged();
        }else {
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<AjendaList>> loader) {
        loader.forceLoad();
    }
}
