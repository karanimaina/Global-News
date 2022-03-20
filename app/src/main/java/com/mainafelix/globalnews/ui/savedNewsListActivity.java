package com.mainafelix.globalnews.ui;//package com.mainafelix.globalnews.ui;//package com.mainafelix.globalnews.ui;

//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Adapter;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
//import com.mainafelix.globalnews.Constants;
//import com.mainafelix.globalnews.R;
//import com.mainafelix.globalnews.adapters.FirebaseNewsViewholder;
//import com.mainafelix.globalnews.adapters.FirenaseNewsListAdapter;
//import com.mainafelix.globalnews.models.Article;
//import com.mainafelix.globalnews.models.SelectListener;
//import com.mainafelix.globalnews.util.ItemTouchHelperAdapter;
//import com.mainafelix.globalnews.util.OnStartDragListener;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class savedNewsListActivity extends AppCompatActivity implements OnStartDragListener {
//    Article article;
//  private  DatabaseReference newsReference;
//    private ListView ListSavedNews;
//    ArrayList<Article>headlines;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved_news_list);
//        ListSavedNews = findViewById(R.id.saved);
//        headlines = new ArrayList<Article>();
//        initializeListView();
//
//
//
//
//    }
//
//    private void initializeListView() {
//        final  ArrayAdapter<Article>adapter = new ArrayAdapter<Article>(this, android.R.layout.simple_dropdown_item_1line,headlines );
//        newsReference =FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LIKED);
//newsReference.addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(@NonNull DataSnapshot snapshot) {
//        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//
//        }
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError error) {
//
//    }
//});
//newsReference.addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(@NonNull DataSnapshot snapshot) {
//        headlines.clear();
//        for (DataSnapshot dataSnapshot :snapshot.getChildren()){
//            Article artics = dataSnapshot.getValue(Article.class);
//            headlines.add(artics);
//            adapter.notifyDataSetChanged();
//    }}
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError error) {
//
//    }
//});
//
//        ListSavedNews.setAdapter(adapter);
//
//    }
//
//
//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//
//    }
//
//}




//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Adapter;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
//import com.mainafelix.globalnews.Constants;
//import com.mainafelix.globalnews.R;
//import com.mainafelix.globalnews.adapters.FirebaseNewsViewholder;
//import com.mainafelix.globalnews.adapters.FirenaseNewsListAdapter;
//import com.mainafelix.globalnews.models.Article;
//import com.mainafelix.globalnews.models.SelectListener;
//import com.mainafelix.globalnews.util.ItemTouchHelperAdapter;
//import com.mainafelix.globalnews.util.OnStartDragListener;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class savedNewsListActivity extends AppCompatActivity implements OnStartDragListener {
//    private  DatabaseReference newsReference;
//    private ListView ListSavedNews;
//    private FirebaseDatabase firebaseDatabase;
//    private FirebaseAuth auth;
//    private FirebaseAuth.AuthStateListener  authStateListener;
//    private String userId;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved_news_list);
//        ListSavedNews = findViewById(R.id.saved);
//        auth = FirebaseAuth.getInstance();
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        newsReference = firebaseDatabase.getReference();
//        FirebaseUser  user  = auth.getCurrentUser();
//        userId = user.getUid();
//
//        auth = FirebaseAuth.getInstance();
//        authStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//            }
//        };
//        auth = FirebaseAuth.getInstance();
//        authStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
//                } else {
//
//                }
//            }
//        };
//
//
//
//newsReference.addValueEventListener(new ValueEventListener() {
//    @Override
//    public void onDataChange(@NonNull DataSnapshot snapshot) {
//        showData(snapshot);
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError error) {
//
//    }
//});
//
//
//    }
//
//    private void showData(DataSnapshot snapshot) {
//        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//          Article article = new Article();
//          article.setTitle(dataSnapshot.child(userId).getValue(Article.class).getTitle());
//          article.setAuthor(dataSnapshot.child(userId).getValue(Article.class).getAuthor());
//          article.setContent(dataSnapshot.child(userId).getValue(Article.class).getContent());
//          article.setDescription(dataSnapshot.child(userId).getValue(Article.class).getDescription());
//          article.setPublishedAt(dataSnapshot.child(userId).getValue(Article.class).getPublishedAt());
//          article.setUrl(dataSnapshot.child(userId).getValue(Article.class).getUrl());
//          article.setUrlToImage(dataSnapshot.child(userId).getValue(Article.class).getUrlToImage());
//
//
//          ArrayList<String> news = new ArrayList<>();
//          news.add(article.getTitle());
//          news.add(article.getAuthor());
//          news.add(article.getPublishedAt());
//          news.add(article.getUrl());
//          news.add(article.getDescription());
//          news.add(article.getUrlToImage());
//          ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,news);
//          ListSavedNews.setAdapter(adapter);
//        }
//    }
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        auth.addAuthStateListener(authStateListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (authStateListener != null) {
//            auth.removeAuthStateListener(authStateListener);
//        }
//    }
//
//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//
//    }
//}




//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.mainafelix.globalnews.Constants;
//import com.mainafelix.globalnews.R;
//import com.mainafelix.globalnews.adapters.FirenaseNewsListAdapter;
//import com.mainafelix.globalnews.models.Article;
//import com.mainafelix.globalnews.util.OnStartDragListener;
//import com.mainafelix.globalnews.util.SimpleItemTouchHelperCallback;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class savedNewsListActivity extends AppCompatActivity implements OnStartDragListener {
//    private DatabaseReference newsReference;
//    private FirenaseNewsListAdapter mFirebaseAdapter;
//    private ItemTouchHelper mItemTouchHelper;
//
//    @BindView(R.id.recycler_main)
//    RecyclerView mRecyclerView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news);
//        ButterKnife.bind(this);
//
//
//        setUpFirebaseAdapter();
//    }
//
//    private void setUpFirebaseAdapter(){
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        Query query = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LIKED).child(uid).orderByChild(Constants.FIREBASE_QUERY_INDEX);
//        FirebaseRecyclerOptions<Article> options =
//                new FirebaseRecyclerOptions.Builder<Article>()
//                        .setQuery(query, Article.class)
//                        .build();
//
//        mFirebaseAdapter = new FirenaseNewsListAdapter(options, query, this, this);
//
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//        mRecyclerView.setHasFixedSize(true);
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(mFirebaseAdapter!= null) {
//            mFirebaseAdapter.stopListening();
//        }
//    }
//
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
//        mItemTouchHelper.startDrag(viewHolder);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(mFirebaseAdapter!= null) {
//            mFirebaseAdapter.stopListening();
//        }
//    }
//}


import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mainafelix.globalnews.Constants;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.adapters.MyAdapter;
import com.mainafelix.globalnews.models.Article;

import java.util.ArrayList;

import butterknife.BindAnim;

public  class savedNewsListActivity extends AppCompatActivity {
RecyclerView recyclerView;
DatabaseReference databaseReference;
MyAdapter myAdapter;
ArrayList<Article>articleArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityfirebase);

        recyclerView = findViewById(R.id.recyclerView);
        databaseReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LIKED);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleArrayList =  new ArrayList<>();
        myAdapter = new MyAdapter(this, articleArrayList);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                articleArrayList.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Article article = dataSnapshot.getValue(Article.class);
                     articleArrayList.add(article);
                    shakeAnimation();

                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    private void shakeAnimation(){
        Animation shake= AnimationUtils.loadAnimation(savedNewsListActivity.this,R.anim.shake_animation);
        recyclerView.setAnimation(shake);

    }
}
