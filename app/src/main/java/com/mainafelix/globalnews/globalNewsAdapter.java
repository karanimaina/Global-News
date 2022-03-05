package com.mainafelix.globalnews;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class globalNewsAdapter extends RecyclerView.Adapter<GlobalViewHolder> {
    private Context context;
    private String[] Articles;



    public globalNewsAdapter( Context context, int resource, String[] articles ) {
        super(context, resource);
        this.context = context;
        Articles = articles;


    }
    @Override
    public Object getItem(int position) {
        String article = Articles[position];

        return String.format("%s \nTrending News: %s", article);
    }

    @Override
    public int getCount() {
        return Articles.length;
    }
}
