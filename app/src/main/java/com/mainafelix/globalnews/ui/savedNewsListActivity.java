package com.mainafelix.globalnews.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mainafelix.globalnews.Constants;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.adapters.FirebaseNewsViewholder;
import com.mainafelix.globalnews.models.Article;

import butterknife.BindView;
import butterknife.ButterKnife;

public class savedNewsListActivity extends AppCompatActivity {
    private DatabaseReference newsReference;
    private FirebaseRecyclerAdapter<Article, FirebaseNewsViewholder> firebaseAdapter;
    @BindView(R.id.recycler_main)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        newsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LIKED);
        setUpFirebaseAdapter();
        hideProgressBar();
        showNews();
    }
    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Article> options = new FirebaseRecyclerOptions.Builder<Article>()
                        .setQuery(newsReference, Article.class)
                        .build();
       firebaseAdapter = new FirebaseRecyclerAdapter<Article, FirebaseNewsViewholder>(options) {
           @NonNull
           @Override
           public FirebaseNewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
               View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list, parent, false);
               return new FirebaseNewsViewholder(view);
           }
           @Override
           protected void onBindViewHolder(@NonNull FirebaseNewsViewholder holder, int position, @NonNull Article article) {
             holder.bindNewsAricles(article);
           }

};
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(firebaseAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAdapter!= null) {
            firebaseAdapter.stopListening();
        }
    }

    private void showNews() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}

