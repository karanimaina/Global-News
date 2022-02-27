package com.mainafelix.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {
    public static final String TAG = NewsActivity.class.getSimpleName();
    @BindView(R.id.newsTextView)
    TextView newsTextView;
    @BindView(R.id.listView)
    ListView listView;
    private String[]articles = new String[] {"Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food", "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar", "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };
    private String[] news = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
       globaArrayAdapter adapter  = new MyRestaurantsArrayAdapter (this, android.R.layout.simple_list_item_1,restaurants,cuisines);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
}