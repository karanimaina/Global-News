package com.mainafelix.globalnews;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class globalNewsAdapter extends ArrayAdapter {
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
//package com.mainafelix.globalnews;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class globalNewsAdapter extends ArrayAdapter {
//    private ArrayList<Articles> articlesArrayList;
//    private Context context;
//
//
//    public globalNewsAdapter( Context context, int resource, ArrayList<Articles> articlesArrayList ) {
//        super(context, resource);
//        this.context = context;
//        this.articlesArrayList = articlesArrayList;
//    }
//    @NonNull
//    @Override
//    public globalNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item, parent,false);
//        return new globalNewsAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull globalNewsAdapter.ViewHolder holder, int position) {
//        Articles  articles =  articlesArrayList.get(position);
//        holder.subtitleTv.setText(articles.getDescription());
//        holder.titleTV.setText(articles.getTitle());
//        Picasso.get().load(articles.getUrlToImage()).into(holder.newsIV);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//                                               @Override
//                                               public void onClick(View view) {
//                                                   Intent i = new Intent(context,NewsDeatilActivity.class);
//                                                   i.putExtra("titile",articles.getTitle());
//                                                   i.putExtra("content",articles.getContent());
//                                                   i.putExtra("description",articles.getDescription());
//                                                   i.putExtra("image",articles.getUrlToImage());
//                                                   i.putExtra("titile",articles.getTitle());
//                                                   i.putExtra("url",articles.getUrl());
//                                                   context.startActivity(i);
//                                               }
//                                           }
//        );
//    }
//
//    @Override
//    public int getItemCount() {
//        return articlesArrayList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView titleTV,subtitleTv;
//        private ImageView newsIV;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            titleTV = itemView.findViewById(R.id.TVNewsHeading);
//            subtitleTv= itemView.findViewById(R.id.TVSubtitle);
//            newsIV =  itemView.findViewById(R.id.IVNews);
//
//        }
//    }
//}




