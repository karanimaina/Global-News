package com.mainafelix.globalnews;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class globalNewsAdapter extends ArrayAdapter {
    private Context context;
    private String[] Articles;
    private String[] news;


    public globalNewsAdapter( Context context, int resource, String[] articles, String[] news ) {
        super(context, resource);
        this.context = context;
        Articles = articles;
        this.news = news;

    }
    @Override
    public Object getItem(int position) {
        String article = Articles[position];
        String newsa = news[position];
        return String.format("%s \nTrending News: %s", article,newsa);
    }

    @Override
    public int getCount() {
        return Articles.length;
    }
}




