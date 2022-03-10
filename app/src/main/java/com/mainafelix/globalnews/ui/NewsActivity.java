package com.mainafelix.globalnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.mainafelix.globalnews.models.OnFetchDataListener;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.network.RequestManager;
import com.mainafelix.globalnews.models.SelectListener;
import com.mainafelix.globalnews.globalNewsAdapter;
import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.models.NewsCollection;

import java.util.List;

public class NewsActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {
    RecyclerView recyclerView;
    globalNewsAdapter adapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView searchView;
    Spinner spinner;
    String country;
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("fetching news Articles of " + query);
                dialog.show();
                RequestManager manager = new RequestManager(NewsActivity.this);
//                add country ;
//                add category
             manager.getNewsHeadlines(listener,"general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
//        Intent intent = getIntent();
//        int positionToShowToSpinner = Integer.parseInt(intent.getStringExtra("position"));
//        spinner.setSelection(positionToShowToSpinner);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news Articles");
        dialog.show();

        b1 = findViewById(R.id.btn_1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.btn_2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.btn_3);
        b3.setOnClickListener(this);
        b4 = findViewById( R.id.btn_4);
        b4.setOnClickListener(this);
        b5 = findViewById( R.id.btn_5);
        b5.setOnClickListener(this);
        b6 = findViewById( R.id.btn_6);
        b6.setOnClickListener(this);
        b7 = findViewById( R.id.btn_7);
        b7.setOnClickListener(this);
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"general",null);
    }
    private final OnFetchDataListener<NewsCollection> listener = new OnFetchDataListener<NewsCollection>() {
        @Override
        public void OnFetchData(List<Article> list, String message) {
            if (list.isEmpty()){
                Toast.makeText(NewsActivity.this,"No news found",Toast.LENGTH_SHORT).show();
            }else{
                showNews(list);
                dialog.dismiss();
            }
        }
        @Override
        public void OnError(String message) {
            Toast.makeText(NewsActivity.this,"an error occured",Toast.LENGTH_SHORT).show();
        }
    };
    private void showNews(List<Article> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new globalNewsAdapter(this, list,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnNewsClick(Article headlines) {
        startActivity(new Intent(NewsActivity.this, NewsDetailActivity.class)
                .putExtra("Data",headlines)
        );

    }

    @Override
    public void onClick(View view) {
        Button  button = (Button) view;
        String category = button.getText().toString();
        dialog.setTitle("fetching "+ category +" News ");
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,category ,null);

    }
}