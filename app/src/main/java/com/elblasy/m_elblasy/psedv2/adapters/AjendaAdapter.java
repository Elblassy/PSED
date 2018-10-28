package com.elblasy.m_elblasy.psedv2.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.list.AjendaList;

import java.util.ArrayList;

public class AjendaAdapter extends RecyclerView.Adapter<AjendaAdapter.ViewHolder> {


    private ArrayList<AjendaList> list;

    public AjendaAdapter(ArrayList<AjendaList> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(com.elblasy.m_elblasy.psedv2.R.layout.ajenda_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  AjendaList ajendaList = list.get(position);


        holder.time.setText(ajendaList.getTime());
        holder.date.setText(ajendaList.getDate());
        holder.event.setText(ajendaList.getEvent());
        holder.name.setText(ajendaList.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        TextView name;
        TextView date;
        TextView event;

        public ViewHolder(View itemView) {
            super(itemView);

            time = itemView.findViewById(com.elblasy.m_elblasy.psedv2.R.id.time);
            name = itemView.findViewById(com.elblasy.m_elblasy.psedv2.R.id.name);
            event = itemView.findViewById(com.elblasy.m_elblasy.psedv2.R.id.event);
            date = itemView.findViewById(com.elblasy.m_elblasy.psedv2.R.id.date);

        }
    }
}
