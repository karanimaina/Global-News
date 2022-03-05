package com.mainafelix.globalnews;

import static com.mainafelix.globalnews.Constants.NEWS_API_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.models.NewsCollection;
import com.mainafelix.globalnews.models.Source;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    globalNewsAdapter adapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById( R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("fetching news Articles of "+query);
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listener,"general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

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
    private final OnFetchDataListener<NewsPracticeResponse>listener = new OnFetchDataListener<NewsPracticeResponse>() {
        @Override
        public void OnFetchData(List<NewsHeadlines> list, String message) {
            if (list.isEmpty()){
                Toast.makeText(MainActivity.this,"No news found",Toast.LENGTH_SHORT).show();
            }else{
                showNews(list);
                dialog.dismiss();
            }
        }

        @Override
        public void OnError(String message) {
            Toast.makeText(MainActivity.this,"an error occured",Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this, list,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnNewsClick(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this,DetailsActivity.class)
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
        manager.getNewsHeadlines(listener,category,null);

    }
}

