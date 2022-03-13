package com.mainafelix.globalnews.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mainafelix.globalnews.Constants;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.models.Article;
import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity  implements View.OnClickListener{
    Article headlines;
    TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
    ImageView img_news;
    Button likedNews;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);


        txt_title = findViewById(R.id.text_detail_title);
        txt_content =findViewById(R.id.text_detail_content);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_author =findViewById(R.id.text_detail_author);
        img_news  = findViewById(R.id.img_detail_news);
        txt_time = findViewById(R.id.text_detail_time);
        likedNews = findViewById(R.id.Likebutton);

        headlines = (Article) getIntent().getSerializableExtra("Data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_content.setText(headlines.getContent());
        txt_detail.setText(headlines.getDescription());
        txt_time .setText(headlines.getPublishedAt());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);



    }

    @Override
    public void onClick(View view) {
  if (view == likedNews ){
      DatabaseReference databaseReference = FirebaseDatabase
              .getInstance().getReference(Constants.FIREBASE_CHILD_LIKED);
      databaseReference.push().setValue(headlines);
      Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

  }
    }
}


