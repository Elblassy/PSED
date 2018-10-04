package com.example.m_elblasy.psedv2.activities;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
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
import com.example.m_elblasy.psedv2.adapters.CellsProjectsAdapter;
import com.example.m_elblasy.psedv2.list.ItemsForCells;
import com.example.m_elblasy.psedv2.loaders.ProjectsLoader;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;


import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<ItemsForCells>> {
    private static final String TAG = "Projects";
    private static final String JSON_PROJECTS_URL = "https://api.myjson.com/bins/us0ls";
    //private static final List<String> JSON_PROJECTS_URL = "https://api.myjson.com/bins/pc04g";
    static CellsProjectsAdapter cellsProjectsAdapter;
    RecyclerView mRecyclerView;
    List<ItemsForCells> data = new ArrayList<>();
    ArrayList<ItemsForCells> list = new ArrayList<>();
    private static final int PROJECTS_LOADER_ID = 1;
    ProgressBar progressBar;

    private ImageView emptyView,noInternet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        mRecyclerView = findViewById(R.id.list_item_projects);
        progressBar = (GoogleProgressBar) findViewById(R.id.progressBar);
        emptyView = (ImageView)findViewById(R.id.emptyview);
        noInternet = (ImageView)findViewById(R.id.noInternetConnection);


        list = ItemsForCells.getList();

        cellsProjectsAdapter = new CellsProjectsAdapter(this, list , data);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(false);



        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            getLoaderManager().initLoader(PROJECTS_LOADER_ID, null, this);
        }else {
            progressBar.setVisibility(View.GONE);
            noInternet.setVisibility(View.VISIBLE);
        }

        initAnimation();
        getWindow().setAllowEnterTransitionOverlap(false);

    }


    @Override
    public Loader<List<ItemsForCells>> onCreateLoader(int i, Bundle bundle) {
        return new ProjectsLoader(this, JSON_PROJECTS_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<ItemsForCells>> loader, List<ItemsForCells> itemsForCells) {

        progressBar.setVisibility(View.GONE);
        if (itemsForCells != null && !itemsForCells.isEmpty()) {
            data.clear();
            data.addAll(itemsForCells);
            mRecyclerView.setAdapter(cellsProjectsAdapter);
            cellsProjectsAdapter.notifyDataSetChanged();
        }else {
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<ItemsForCells>> loader) {
        loader.forceLoad();

    }


    private void initAnimation() {

        Slide enterTransition = new Slide();
        enterTransition.setSlideEdge(Gravity.END);
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
        getWindow().setEnterTransition(enterTransition);
    }
}