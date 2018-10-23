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
import com.example.m_elblasy.psedv2.activities.AboutUs;
import com.example.m_elblasy.psedv2.list.AboutUsList;
import com.example.m_elblasy.psedv2.list.GrideList;

import java.util.ArrayList;
import java.util.List;

public class AboutUsAdapter extends RecyclerView.Adapter<AboutUsAdapter.ViewHolder> {
    private static final String TAG = "AboutUsAdapter";
    private Context context;
    private List<List<GrideList>> grideList;
    private List<AboutUsList> aboutUsList;
    public AboutUsAdapter(Context context, List<List<GrideList>> grideList,List<AboutUsList> aboutUsList) {
        this.context = context;
        this.grideList = grideList;
        this.aboutUsList = aboutUsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_work, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final List<GrideList> gride = grideList.get(position);
        final AboutUsList aboutUses = aboutUsList.get(position);
        Log.i(TAG, "gride" + position);

        GrideAdapter grideAdapter = new GrideAdapter(context, gride);


        holder.leader.setImageResource(aboutUses.getLeader());
        holder.nameOfLeader.setText(aboutUses.getNameOfLeader());
        holder.bg.setImageResource(aboutUses.getBg());
        holder.dis.setText(aboutUses.getDes());
        holder.team.setText(aboutUses.getTeam());

        holder.gridView.setLayoutManager(new GridLayoutManager(context, 4));
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
        ImageView bg;
        TextView dis;
        TextView team;


        public ViewHolder(View itemView) {
            super(itemView);

            gridView = (RecyclerView) itemView.findViewById(R.id.team_work);
            leader = (ImageView) itemView.findViewById(R.id.leader);
            nameOfLeader = (TextView) itemView.findViewById(R.id.name_of_leader);
            bg = (ImageView)itemView.findViewById(R.id.background_of_teamwork);
            dis = (TextView)itemView.findViewById(R.id.dis_of_leader);
            team = (TextView)itemView.findViewById(R.id.title_of_team);
        }
    }
}
