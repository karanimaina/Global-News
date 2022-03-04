package com.mainafelix.globalnews;

import androidx.appcompat.app.AppCompatActivity;

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
//
        NewsApi client = NewsClient.getClient();
        Call<NewsCollection> call = client.getArticle("us");
        call.enqueue(new Callback<NewsCollection>() {
            @Override
            public void onResponse(Call<NewsCollection> call, Response<NewsCollection> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    List<Article> articlesList = response.body().getArticles();
                    String[] newsArticles = new String[articlesList.size()];
                    for (int i = 0; i < newsArticles.length; i++) {
                        newsArticles[i] = articlesList.get(i).getTitle();
                    }
                    ArrayAdapter adapter = new globalNewsAdapter(NewsActivity.this, android.R.layout.simple_list_item_1, newsArticles);
                    listView.setAdapter(adapter);
                    showArticles();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<NewsCollection> call, Throwable t) {
                Log.e("Error Message", "onFailure: ", t);
                hideProgressBar();
                showFailureMessage();
            }
        });
    }
}

