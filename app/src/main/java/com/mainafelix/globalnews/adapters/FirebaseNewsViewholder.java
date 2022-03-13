package com.mainafelix.globalnews.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mainafelix.globalnews.Constants;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.ui.NewsDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;

public class FirebaseNewsViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
   View view;
   Context context;

    public FirebaseNewsViewholder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        this.context =itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindNewsAricles(Article article) {
         ImageView img_news =( ImageView)view.findViewById(R.id.imageView);
       TextView txt_author= (TextView)view.findViewById(R.id.text_detail_author);
        TextView  txt_title =(TextView)view.findViewById (R.id.text_detail_title);
       TextView txt_time = ( TextView)view.findViewById (R.id.text_detail_time);
        TextView txt_detail = (TextView)view.findViewById(R.id.text_detail_detail) ;
         TextView txt_content  =(TextView)view.findViewById (R.id.text_detail_content);
        txt_title.setText(article.getTitle());
        txt_author.setText(article.getAuthor());
       txt_content.setText(article.getContent());
       txt_detail.setText(article.getDescription());
       txt_time .setText(article.getPublishedAt());
       Picasso.get().load(article.getUrlToImage()).into(img_news);

    }
    @Override
    public void onClick(View view) {
   final ArrayList<Article>articles = new ArrayList<>();
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_NEWS);
//        reference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    articles.add(snapshot.getValue(Article.class));
//                }
//                int  itemPosition = getLayoutPosition();
//                Intent intent = new Intent(context, NewsDetailActivity.class);
//                intent.putExtra("position",itemPosition + "");
//                intent.putExtra("articles" , Parcels.wrap(articles));
//                context.startActivity(intent);
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}}
