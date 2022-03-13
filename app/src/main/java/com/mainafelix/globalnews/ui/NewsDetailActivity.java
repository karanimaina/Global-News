package com.mainafelix.globalnews.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mainafelix.globalnews.Constants;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.models.Article;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//public class NewsDetailActivity extends AppCompatActivity  {
//    Article headlines;
//    TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
//    ImageView img_news;
//    Button like;
//    TextView savedText;
//    private  DatabaseReference databaseReference;
//    private ValueEventListener LikedNews;
//    private Article  articles;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news_detail);
//         databaseReference = FirebaseDatabase
//                 .getInstance().getReference().child(Constants.FIREBASE_CHILD_LIKED);
//    LikedNews = databaseReference.addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
//        for (DataSnapshot newsSnapshot : dataSnapshot.getChildren()) {
//            String savedNews = newsSnapshot.getValue().toString();
//            Log.d("news updated", "news: " +savedNews); //log
//        }
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError error) {
//
//    }
//});
//        txt_title = findViewById(R.id.text_detail_title);
//        txt_content =findViewById(R.id.text_detail_content);
//        txt_detail = findViewById(R.id.text_detail_detail);
//        txt_author =findViewById(R.id.text_detail_author);
//        img_news  = findViewById(R.id.img_detail_news);
//        txt_time = findViewById(R.id.text_detail_time);
//        like = findViewById(R.id.Likebutton);
//        savedText = findViewById(R.id.text_detail_detail);
//
//        headlines = (Article) getIntent().getSerializableExtra("Data");
//
//        txt_title.setText(headlines.getTitle());
//        txt_author.setText(headlines.getAuthor());
//        txt_content.setText(headlines.getContent());
//        txt_detail.setText(headlines.getDescription());
//        txt_time .setText(headlines.getPublishedAt());
//        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
//
//
//    }
//
////    @Override
////    public void onClick(View view) {
////     if (view == like ){
////        DatabaseReference savedNews = FirebaseDatabase
////                .getInstance()
////                .getReference(Constants.FIREBASE_CHILD_LIKED);
////        savedNews.push().setValue(articles);
////     }
////    }
//
//    private void saveNewsToFirebase(String news) {
//        databaseReference.push().setValue(news);
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        databaseReference.removeEventListener(LikedNews);
//    }
//
//@BindView(R.id.viewPager)
//ViewPager mViewPager;
//    private NewsPagerAdapter adapterViewPager;
//    List<Article>headlines;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news_detail);
//        ButterKnife.bind(this);
//
//       headlines = Parcels.unwrap(getIntent().getParcelableExtra("restaurants"));
//        int startingPosition = getIntent().getIntExtra("position", 0);
//
//        adapterViewPager = new NewsPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,headlines);
//        mViewPager.setAdapter(adapterViewPager);
//        mViewPager.setCurrentItem(startingPosition);
//    }
public class NewsDetailActivity extends AppCompatActivity {
    Article headlines;
    TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
    ImageView img_news;
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

        headlines = (Article) getIntent().getSerializableExtra("Data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_content.setText(headlines.getContent());
        txt_detail.setText(headlines.getDescription());
        txt_time .setText(headlines.getPublishedAt());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);


    }
}


