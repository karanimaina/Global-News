package com.mainafelix.globalnews;

import static com.mainafelix.globalnews.Constants.NEWS_API_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    CustomAdapter adapter;
    public static final String TAG = NewsActivity.class.getSimpleName();
    @BindView(R.id.newsTextView)
    TextView newsTextView;
    @BindView(R.id.listView)
    ListView listView;
    private ArrayList<Article> articlesArrayList;
    private static final String TAG1 = NewsActivity.class.getSimpleName();
    @BindView(R.id.errorTextView) TextView errorTextView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private void showFailureMessage() {
        errorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        errorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        errorTextView.setText("Something went wrong. Please try again later");
        errorTextView.setVisibility(View.VISIBLE);
    }

    private void showArticles() {
        listView.setVisibility(View.VISIBLE);
        newsTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String q = ((TextView) view).getText().toString();
                Toast.makeText(NewsActivity.this, q, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();// recreating sn intent
        String q = intent.getStringExtra("search");//fetching the data fom the intent
        newsTextView.setText("Current headlines:" + q);//set text updates the text on LocationTextView to include the text+ defined location,
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"general",null);
    }
    private final OnFetchDataListener<NewsCollection>listener = new OnFetchDataListener<NewsCollection>() {
        @Override
        public void OnFetchData(List<Article> list, String message) {
            showNews(list);
        }

        @Override
        public void OnError(String message) {

        }
    };

    private void showNews(List<Article> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(adapter);

    }
}

