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
    private ArrayList<Articles> articlesArrayList;
    //private String[]articles = new String[] {"Why is affordable housing plan favouring employed Kenyans?", "Covid -19 crisis", "Inter-country wars between Ukraine and russia", "NASA discovers a black hole in space", "How to handle poverty crisis", "Economy bulletin :" };
    //private String[]news = new String[] {"government has imposed a percentage monthly deduction to provide affordable housing  to citizens","due to the upsurge of covid19 citizens are advised to wear mask and sanitize regularly","war intensifies in areas around kiev ukraine,putin  declares that ukraine should not be regarded as a country ,", "Scientist are digging more on the causes o n the origin of  the black hole", "To solve crisis the government should  make free education available to all, people need skills",  "Gold prices lower due to the ongoing crisis between ukraine and  russia" };
    private static final String TAG1 = NewsActivity.class.getSimpleName();
    @BindView(R.id.errorTextView) TextView errorTextView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
      // globalNewsAdapter adapter  = new globalNewsAdapter (this, android.R.layout.simple_list_item_1,articles,news );
       // listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String article = ((TextView)view).getText().toString();
                Toast.makeText(NewsActivity.this,article,Toast.LENGTH_LONG).show();
                Log.v(TAG,"in the on itemclick listener");
            }
        });
        Intent intent = getIntent();// recreating sn intent
        String country=intent.getStringExtra("country");//fetching the data fom the intent
        newsTextView.setText("Current headlines:" + country );//set text updates the text on LocationTextView to include the text+ defined location,
//        // Log.d(TAG, "In the onCreate method!");
       listView = (ListView) findViewById(R.id.listView);

NewsApi client = NewsClient.getClient();
Call<News> call = client.getAllNews(country,"News");
        call.enqueue(new Callback<News>(){
          @Override
          public void onResponse(Call<News> call, Response<News> response) {
              hideProgressBar();
              if (response.isSuccessful()) {
                  List<Articles> articles = response.body().getArticles();
                  for (int i = 0; i < articles.size(); i++) {
                      articlesArrayList.add(new Articles(articles.get(i).getTitle(), articles.get(i).getDescription(), articles.get(i).getUrlToImage(), articles.get(i).getUrl(), articles.get(i).getContent()));
                  }
                  ArrayAdapter adapter = new globalNewsAdapter(NewsActivity.this,android.R.layout.simple_list_item_1,articles);
                  listView.setAdapter(adapter);
                  showNews();
              }else {
                  showUnsuccessfulMessage();
              }
          }

          @Override
          public void onFailure(Call<News> call, Throwable t) {
              Toast.makeText(NewsActivity.this,"Fail to get news",Toast.LENGTH_SHORT).show();
              Log.e("Error Message", "onFailure: ",t );
              hideProgressBar();
              showFailureMessage();
          }
      });



            }
    private void showFailureMessage() {
        errorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        errorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        errorTextView.setText("Something went wrong. Please try again later");
        errorTextView.setVisibility(View.VISIBLE);
    }

    private void showNews() {
        listView.setVisibility(View.VISIBLE);
        newsTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }


}
