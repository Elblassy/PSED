package com.example.m_elblasy.psedv2.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.m_elblasy.psedv2.CustomItemClickListener;
import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.list.ModelOfData;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;

import java.util.List;

public class SpeakersAdapter extends RecyclerView.Adapter<SpeakersAdapter.MyViewHolder> {

    private List<ModelOfData> modelOfDataList;
    Context context;
    CustomItemClickListener listener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.speakers_list, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, myViewHolder.getLayoutPosition());
            }
        });

        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        final ModelOfData modelOfData = modelOfDataList.get(position);
        holder.name.setText(modelOfData.getName());
        Bitmap bm = modelOfData.getImage();

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.shape);

        Glide.with(context)
                .asBitmap()
                .load(bm)
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return modelOfDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public TextView dis;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.name);
            this.image = (ImageView) itemView.findViewById(R.id.image_speaker);

        }
    }


    public SpeakersAdapter(List<ModelOfData> modelOfDataList, Context context, CustomItemClickListener listener) {
        this.modelOfDataList = modelOfDataList;
        this.context = context;
        this.listener = listener;
    }


}
