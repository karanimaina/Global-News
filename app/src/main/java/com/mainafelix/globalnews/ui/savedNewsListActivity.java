package com.mainafelix.globalnews.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.mainafelix.globalnews.Constants;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.adapters.FirebaseNewsViewholder;
import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.models.SelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class savedNewsListActivity extends AppCompatActivity implements SelectListener {
    Article article;
    DatabaseReference newsReference;
    private FirebaseRecyclerAdapter<Article, FirebaseNewsViewholder> firebaseAdapter;

   private ListView ListSavedNews;
    ArrayList<Article>headlines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_news_list);
        ListSavedNews = findViewById(R.id.saved);
        headlines = new ArrayList<Article>();
        initializeListView();




    }

    private void initializeListView() {
        final  ArrayAdapter<Article>adapter = new ArrayAdapter<Article>(this, android.R.layout.simple_dropdown_item_1line,headlines );
        newsReference =FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LIKED);



        newsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                headlines.add(snapshot.getValue(Article.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            headlines.remove(snapshot.getValue(Article.class));
            adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ListSavedNews.setAdapter(adapter);

    }

    @Override
    public void OnNewsClick(Article headlines) {

    }
}

