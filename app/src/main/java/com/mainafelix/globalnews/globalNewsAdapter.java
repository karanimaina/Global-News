package com.mainafelix.globalnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mainafelix.globalnews.models.Article;

import java.util.List;

public class globalNewsAdapter extends RecyclerView.Adapter<GlobalViewHolder> {
    private Context context;
    private List<Article> heeadlines;

    public globalNewsAdapter(Context context, List<Article> heeadlines) {
        this.context = context;
        this.heeadlines = heeadlines;
    }

    @NonNull
    @Override
    public GlobalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GlobalViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_news,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GlobalViewHolder holder, int position) {
    holder.t
    }

    @Override
    public int getItemCount() {
        return  heeadlines.size();
    }
}