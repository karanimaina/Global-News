package com.mainafelix.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mainafelix.globalnews.models.Article;
import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    Article headlines;
    TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
    ImageView img_news;
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

        headlines = (Article) getIntent().getSerializableExtra("Data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_content.setText(headlines.getContent());
        txt_detail.setText(headlines.getDescription());
        txt_time .setText(headlines.getPublishedAt());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);


    }
}