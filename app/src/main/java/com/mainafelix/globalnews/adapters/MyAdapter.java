package com.mainafelix.globalnews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.models.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyviewHolder>{

Context context;
ArrayList<Article>list;

    public MyAdapter(Context context, ArrayList<Article> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
       return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
      Article article = list.get(position);
      holder.title.setText(article.getTitle());
      holder.author.setText(article.getAuthor());
      holder.publish.setText(article.getPublishedAt());
      holder.content.setText(article.getContent());
      holder.description.setText(article.getDescription());
      holder.url.setText(article.getUrl());
      Picasso.get().load(article.getUrlToImage()).into(holder.imageUrl);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyviewHolder extends  RecyclerView.ViewHolder{
                TextView title,author ,url,description,content,publish;
                ImageView imageUrl;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titlename);
            author = itemView.findViewById(R.id.authorname);
            url = itemView.findViewById(R.id.urlLink);
            description = itemView.findViewById(R.id.descriptionname);
            content = itemView.findViewById(R.id.contentname);
            imageUrl = itemView.findViewById(R.id.imageURl);
            publish = itemView.findViewById(R.id.publishdate);
        }
    }
}
