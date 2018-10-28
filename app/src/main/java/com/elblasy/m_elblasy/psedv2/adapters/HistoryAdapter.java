package com.elblasy.m_elblasy.psedv2.adapters;

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
import com.elblasy.m_elblasy.psedv2.R;
import com.elblasy.m_elblasy.psedv2.activities.ContentOfHistory;

import java.util.List;

import com.elblasy.m_elblasy.psedv2.activities.ContentOfHistory;

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
                    case 3:
                        ActivityOptions options3 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent3 = new Intent(context, ContentOfHistory.class);
                        int image3 = images.get(position);
                        String string3 = text.get(position);
                        intent3.putExtra("image", image3);
                        intent3.putExtra("text", string3);
                        context.startActivity(intent3, options3.toBundle());
                        break;
                    case 4:
                        ActivityOptions options4 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent4 = new Intent(context, ContentOfHistory.class);
                        int image4= images.get(position);
                        String string4 = text.get(position);
                        intent4.putExtra("image", image4);
                        intent4.putExtra("text", string4);
                        context.startActivity(intent4, options4.toBundle());
                        break;
                    case 5:
                        ActivityOptions options5 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent5 = new Intent(context, ContentOfHistory.class);
                        int image5 = images.get(position);
                        String string5 = text.get(position);
                        intent5.putExtra("image", image5);
                        intent5.putExtra("text", string5);
                        context.startActivity(intent5, options5.toBundle());
                        break;
                    case 6:
                        ActivityOptions options6 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent6 = new Intent(context, ContentOfHistory.class);
                        int image6 = images.get(position);
                        String string6 = text.get(position);
                        intent6.putExtra("image", image6);
                        intent6.putExtra("text", string6);
                        context.startActivity(intent6, options6.toBundle());
                        break;
                    case 7:
                        ActivityOptions options7 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent7 = new Intent(context, ContentOfHistory.class);
                        int image7 = images.get(position);
                        String string7 = text.get(position);
                        intent7.putExtra("image", image7);
                        intent7.putExtra("text", string7);
                        context.startActivity(intent7, options7.toBundle());
                        break;
                    case 8:
                        ActivityOptions options8 = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
                        Intent intent8 = new Intent(context, ContentOfHistory.class);
                        int image8 = images.get(position);
                        String string8 = text.get(position);
                        intent8.putExtra("image", image8);
                        intent8.putExtra("text", string8);
                        context.startActivity(intent8, options8.toBundle());
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
