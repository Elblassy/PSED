package com.example.m_elblasy.psedv2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.list.GrideList;

import java.util.ArrayList;
import java.util.List;

public class AboutUsAdapter extends RecyclerView.Adapter<AboutUsAdapter.ViewHolder> {
    private static final String TAG = "AboutUsAdapter";
    private Context context;
    private List<List<GrideList>> grideList;

    public AboutUsAdapter(Context context, List<List<GrideList>> grideList) {
        this.context = context;
        this.grideList = grideList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_work,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final List<GrideList> gride = grideList.get(position);
        Log.i(TAG,"gride" + position);

        GrideAdapter grideAdapter = new GrideAdapter(context,gride);

        holder.gridView.setLayoutManager(new GridLayoutManager(context,4));
        holder.gridView.setItemAnimator(new DefaultItemAnimator());
        holder.gridView.setNestedScrollingEnabled(false);
        holder.gridView.setAdapter(grideAdapter);


    }

    @Override
    public int getItemCount() {
        return grideList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView gridView;
        ImageView leader;
        TextView nameOfLeader;


        public ViewHolder(View itemView) {
            super(itemView);

            gridView = (RecyclerView) itemView.findViewById(R.id.team_work);
            leader = (ImageView)itemView.findViewById(R.id.leader);
        }
    }
}
