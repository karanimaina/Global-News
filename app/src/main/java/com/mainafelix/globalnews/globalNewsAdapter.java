package com.mainafelix.globalnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mainafelix.globalnews.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class globalNewsAdapter extends RecyclerView.Adapter<GlobalViewHolder> {
    private Context context;
    private List<Article> headlines;

    public globalNewsAdapter(Context context, List<Article> heeadlines) {
        this.context = context;
        this.headlines = heeadlines;
    }

    @NonNull
    @Override
    public GlobalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GlobalViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_news,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GlobalViewHolder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());
        if (headlines.get(position).getUrlToImage()!= null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }
    }

    @Override
    public int getItemCount() {
        return  headlines.size();
    }
}