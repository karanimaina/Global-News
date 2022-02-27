package com.mainafelix.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {
    public static final String TAG = NewsActivity.class.getSimpleName();
    @BindView(R.id.newsTextView)
    TextView newsTextView;
    @BindView(R.id.listView)
    ListView listView;
    private String[]articles = new String[] {"Why is affordable housing plan favouring employed Kenyans?", "Cricket", "Covid -19 crisis", "Inter-country wars between Ukraine and russia", "NASA discovers a black holr in space", "How to handle poverty crisis", "Economy bulletin :" };
    private String[] news = new String[] {" residents in Norway prefer Vegan Food as opposed to meat ", "what you should take on Breakfast", "Fish farming has been embraces in denmark",  "Coffee regarded as the no. 1 booster", "what is your preffered English Food" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
       globalNewsAdapter adapter  = new globalNewsAdapter (this, android.R.layout.simple_list_item_1,articles ,news);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String news = ((TextView)view).getText().toString();
                //Log.v("Restaurants.activity","in the onItemClickListener");
                Toast.makeText(NewsActivity.this,news,Toast.LENGTH_LONG).show();
                Log.v(TAG,"in the on itemclick listener");
            }
        });
        Intent intent = getIntent();// recreating sn intent
        String news=intent.getStringExtra("news");//fetching the data fom the intent
        newsTextView.setText("Here are all the news : " + news);//set text updates the text on LocationTextView to include the text+ defined location,
//        // Log.d(TAG, "In the onCreate method!");
       listView = (ListView) findViewById(R.id.listView);


    }
}