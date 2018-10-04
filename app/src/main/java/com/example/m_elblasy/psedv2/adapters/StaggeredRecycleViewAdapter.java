package com.example.m_elblasy.psedv2.adapters;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.m_elblasy.psedv2.activities.Ajenda;
import com.example.m_elblasy.psedv2.activities.HistoryOfPsed;
import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.activities.AboutUs;
import com.example.m_elblasy.psedv2.activities.MainActivity;
import com.example.m_elblasy.psedv2.activities.Projects;
import com.example.m_elblasy.psedv2.activities.Speakers;

import java.util.ArrayList;

public class StaggeredRecycleViewAdapter extends RecyclerView.Adapter<StaggeredRecycleViewAdapter.ViewHolder> {

    private static final String TAG = "StaggeredRecycleViewAda";


    private ArrayList<String> mTitles ;
    private ArrayList<Integer> mImageUrls ;
    private Context mContext;

    public StaggeredRecycleViewAdapter(Context mContext, ArrayList<String> mTitles, ArrayList<Integer> mImageUrls) {
        this.mTitles = mTitles;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gride_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "on BindingViewHolder called.");


        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.shape);

        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);

                        return false;
                    }
                })
                .apply(requestOptions.skipMemoryCache(true))
                .into(holder.imageView);

        holder.title.setText(mTitles.get(position));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mTitles.get(position));

                switch (position) {
                    case 1:
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext);
                        Intent intent = new Intent(mContext, HistoryOfPsed.class);
                        mContext.startActivity(intent,options.toBundle());
                        break;

                    case 2:
                        ActivityOptions options2 = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext);
                        Intent intent2 = new Intent(mContext, Speakers.class);
                        mContext.startActivity(intent2,options2.toBundle());
                        break;
                    case 3:
                        ActivityOptions options1 = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext);
                            Intent intent1 = new Intent(mContext, Projects.class);
                            mContext.startActivity(intent1,options1.toBundle() );
                        break;

                    case 4:
                        Intent intent4 = new Intent(mContext, Ajenda.class);
                        mContext.startActivity(intent4);
                        break;

                    case 5:
                        ActivityOptions options3 = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext);
                        Intent intent3 = new Intent(mContext, AboutUs.class);
                        mContext.startActivity(intent3,options3.toBundle());
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;
        ProgressBar progressBar;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_main);
            this.title = itemView.findViewById(R.id.title);
            this.progressBar = itemView.findViewById(R.id.progressBar);
            this.cardView = itemView.findViewById(R.id.card);
        }
    }
}
