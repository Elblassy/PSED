package com.elblasy.m_elblasy.psedv2.adapters;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elblasy.m_elblasy.psedv2.CustomItemClickListener;
import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.list.ItemsForCells;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

public class CellsProjectsAdapter extends RecyclerView.Adapter<CellsProjectsAdapter.ViewHolder> {
    private static final String TAG = "CellsProjectsAdapter";
    private Context context;
    private List<ItemsForCells> itemsForCells;
    private List<ItemsForCells> itemstitle;
    private List<ItemsForCells> itemscontent;
    private Dialog myDialog;
    private Button back;


    public CellsProjectsAdapter(Context context ,List<ItemsForCells> itemstitle ,List<ItemsForCells> itemscontent, List<ItemsForCells> itemsForCells  ) {
        this.context = context;
        this.itemsForCells = itemsForCells;
        this.itemstitle = itemstitle;
        this.itemscontent = itemscontent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cells, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ItemsForCells items = itemsForCells.get(position);
        final ItemsForCells items1 = itemstitle.get(position);
        final ItemsForCells items2 = itemscontent.get(position);
        final int i = position;

        Log.i(TAG, "mostafa: " + position);

        try {
            Glide.with(context)
                    .asBitmap()
                    .load(items1.getTitleImage())
                    .into(holder.titleImageView);

           /* Glide.with(context)
                    .asBitmap()
                    .load(items2.getTitleImage())
                    .into(holder.contentImageView);*/

            ListOFProjects projectsList = new ListOFProjects(context, items.getListOFProjects().get(position), new CustomItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {

                    Bitmap image = items.getListOFProjects().get(i).get(position).getImageOfProject();
                    String dis = items.getListOFProjects().get(i).get(position).getDis();

                    myCustomAlertDialog(dis, image);
                }
            });
            Log.i(TAG, "elblasy: " + items.getListOFProjects().size());

            RecyclerView.LayoutManager layoutManager =
                    new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            holder.recyclerView.setLayoutManager(layoutManager);
            holder.recyclerView.setAdapter(projectsList);
            projectsList.notifyDataSetChanged();
            holder.recyclerView.setNestedScrollingEnabled(false);


            holder.foldingCell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.foldingCell.toggle(false);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return itemstitle.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView titleImageView;
        ImageView contentImageView;
        FoldingCell foldingCell;
        RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleImageView = (ImageView) itemView.findViewById(R.id.title_image_cell);
           // contentImageView= (ImageView) itemView.findViewById(R.id.content_image_cell);
            foldingCell = (FoldingCell) itemView.findViewById(R.id.folding_cell);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.list_item_cell);

        }
    }

    private void myCustomAlertDialog(String dis, Bitmap image) {
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.custom_dialog);

        TextView disProject = (TextView) myDialog.findViewById(R.id.dis_project);
        disProject.setText(dis);
        disProject.setScroller(new Scroller(context));
        disProject.setVerticalScrollBarEnabled(true);
        disProject.setMovementMethod(new ScrollingMovementMethod());

        ImageView imageProject = (ImageView) myDialog.findViewById(R.id.image_project);
        imageProject.setImageBitmap(image);

        back = (Button) myDialog.findViewById(R.id.back);
        back.setEnabled(true);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.cancel();
            }
        });
        myDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        myDialog.show();
    }
}

