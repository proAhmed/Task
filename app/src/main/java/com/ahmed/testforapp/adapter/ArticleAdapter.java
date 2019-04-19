package com.ahmed.testforapp.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmed.testforapp.R;
import com.ahmed.testforapp.interfaces.OnAdapterClick;
import com.ahmed.testforapp.model.entity.Article;
import com.ahmed.testforapp.screens.mainScreen.MainViewModel;
import com.ahmed.testforapp.util.DateUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;


public class ArticleAdapter extends RecyclerView
        .Adapter<ArticleAdapter
        .DataObjectHolder> {
    private final List<Article> articleServerList = new ArrayList<>();

    private OnAdapterClick<Article> onAdapterClick;

    static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAbstract, tvDate, tvSection;
        ImageView imgThumb;

        DataObjectHolder(View convertView) {
            super(convertView);
            tvTitle = convertView.findViewById(R.id.tvTitle);
            tvAbstract = convertView.findViewById(R.id.tvAbstract);
            tvDate = convertView.findViewById(R.id.tvDate);
            imgThumb = convertView.findViewById(R.id.imgThumb);
            tvSection = convertView.findViewById(R.id.tvSection);
        }
    }

    public ArticleAdapter(LifecycleOwner lifecycleOwner, MainViewModel viewModel, OnAdapterClick<Article> onAdapterClick) {
        this.onAdapterClick = onAdapterClick;
        viewModel.getRepos().observe(lifecycleOwner, articles -> {
            articleServerList.clear();

            if(articles!=null){
                articleServerList.addAll(articles);
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataObjectHolder holder, final int position) {

        Article articleServer = articleServerList.get(position);
        holder.tvTitle.setText(articleServer.getTitle());
        holder.tvAbstract.setText(articleServer.getAbstract());
       String publishedDate = DateUtil.convertDate(articleServer.getPublishedDate());
        holder.tvDate.setText(publishedDate);
        holder.tvSection.setText(articleServer.getSection());

        holder.itemView.setOnClickListener(v ->
                onAdapterClick.onClick(articleServer));


        if(articleServer.getMedia()!=null&& articleServer.getMedia()
                !=null&& articleServer.getMedia() .getMediaMetadata()!=null&&
                articleServer.getMedia().getMediaMetadata().get(0)!=null&&
                articleServer.getMedia().getMediaMetadata().get(0).getUrl()!=null&&
                !articleServer.getMedia().getMediaMetadata().get(0).getUrl().isEmpty())
        Picasso.get().load(articleServer.getMedia().getMediaMetadata().get(0).getUrl()).into(holder.imgThumb);

    }

    @Override
    public int getItemCount() {
        return articleServerList.size();
    }


}
