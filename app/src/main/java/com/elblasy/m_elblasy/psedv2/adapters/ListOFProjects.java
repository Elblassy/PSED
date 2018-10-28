package com.elblasy.m_elblasy.psedv2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elblasy.m_elblasy.psedv2.CustomItemClickListener;
import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.list.ProjectsList;

import java.util.List;


public class ListOFProjects extends RecyclerView.Adapter<ListOFProjects.MyViewHolder> {
    private static final String TAG = "ListOFProjects";
    private List<ProjectsList> projectsLists;
    private Context context;
    private CustomItemClickListener listener;


    public ListOFProjects(Context context, List<ProjectsList> projectsLists, CustomItemClickListener listener) {
        this.projectsLists = projectsLists;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_projects, parent, false);
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ProjectsList list = projectsLists.get(position);


        Glide.with(context)
                .asBitmap()
                .load(list.getImageOfProject())
                .into(holder.imageOfProject);


        Log.i(TAG, "onBindViewHolder: " + projectsLists.size());


    }

    @Override
    public int getItemCount() {
        return projectsLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageOfProject;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageOfProject = (ImageView) itemView.findViewById(R.id.image_projects_list);
        }
    }


}
