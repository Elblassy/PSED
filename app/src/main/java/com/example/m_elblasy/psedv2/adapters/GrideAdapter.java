package com.example.m_elblasy.psedv2.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.list.GrideList;

import java.util.List;

public class GrideAdapter extends RecyclerView.Adapter<GrideAdapter.ViewHolder> {

    Context context;
    private List<GrideList> imageList;
    private static final String TAG = "GrideAdapter";

    public GrideAdapter(Context context,List<GrideList> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_work_image,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final GrideList lists = imageList.get(position);

        Glide.with(context)
                .load(lists.getImage())
                .thumbnail(0.5f)
                .apply(new RequestOptions().skipMemoryCache(true).override(400,500))
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

   public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;


       public ViewHolder(View itemView) {
           super(itemView);

           imageView = itemView.findViewById(R.id.profile);
       }
   }
}
