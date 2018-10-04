package com.example.m_elblasy.psedv2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.m_elblasy.psedv2.R;

import java.util.ArrayList;

public class AjendaAdapter extends RecyclerView.Adapter<AjendaAdapter.ViewHolder> {


    private ArrayList<String> title;
    private ArrayList<String> time;

    public AjendaAdapter( ArrayList<String> title, ArrayList<String> time) {
        this.title = title;
        this.time = time;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ajenda_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.time.setText(time.get(position));
        holder.title.setText(title.get(position));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.time_ajenda);
            title = itemView.findViewById(R.id.title_ajenda);
        }
    }
}
