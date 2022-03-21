package com.mainafelix.globalnews.ui;


import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
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

;
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
        new  ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
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
    ItemTouchHelper.SimpleCallback itemTouchHelper =  new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
         articleArrayList.remove(viewHolder.getAdapterPosition());
            myAdapter.notifyDataSetChanged();
        }
    };
}
