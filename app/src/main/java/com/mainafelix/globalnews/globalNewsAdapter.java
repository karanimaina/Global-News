package com.mainafelix.globalnews;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class globalNewsAdapter extends ArrayAdapter {
    private Context context;
    private String[] articles;
    private String [] news;
    public globalNewsAdapter( Context context, int resource, String[] articles, String[] news) {
        super(context, resource);
        this.context = context;
       this.news = news;
        this.articles = articles;
        this.news = news;
    }


}
