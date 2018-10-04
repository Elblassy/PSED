package com.example.m_elblasy.psedv2.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.m_elblasy.psedv2.R;
import com.example.m_elblasy.psedv2.activities.ContentOfHistory;
import com.example.m_elblasy.psedv2.activities.HistoryOfPsed;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context;
    private List<Integer> list;
    private List<Integer> images;
    private List<String> text;


    public HistoryAdapter(Context context, List<Integer> list, List<Integer> images, List<String> text) {
        this.list = list;
        this.context = context;
        this.images = images;
        this.text = text;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_of_psed_content, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.shape);

        Glide.with(context)
                .load(list.get(position))
                .apply(requestOptions.skipMemoryCache(false))
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {

                    case 0:
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent = new Intent(context, ContentOfHistory.class);
                        int image = images.get(position);
                        String string = text.get(position);
                        intent.putExtra("image", image);
                        intent.putExtra("text", string);
                        context.startActivity(intent, options.toBundle());
                        break;
                    case 1:
                        ActivityOptions options1 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent1 = new Intent(context, ContentOfHistory.class);
                        int image1 = images.get(position);
                        String string1 = text.get(position);
                        intent1.putExtra("image", image1);
                        intent1.putExtra("text", string1);
                        context.startActivity(intent1, options1.toBundle());
                        break;
                    case 2:
                        ActivityOptions options2 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent2 = new Intent(context, ContentOfHistory.class);
                        int image2 = images.get(position);
                        String string2 = text.get(position);
                        intent2.putExtra("image", image2);
                        intent2.putExtra("text", string2);
                        context.startActivity(intent2, options2.toBundle());
                        break;

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.title_of_history);
        }
    }
}
