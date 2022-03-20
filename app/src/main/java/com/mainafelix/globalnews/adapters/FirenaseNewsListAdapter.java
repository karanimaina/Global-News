//package com.mainafelix.globalnews.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.Query;
//import com.mainafelix.globalnews.R;
//import com.mainafelix.globalnews.models.Article;
//
//
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//
//public class FirenaseNewsListAdapter extends FirebaseRecyclerAdapter<Article,FirebaseNewsViewholder> implements ItemTouchHelperAdapter {
//    private DatabaseReference newsReference;
//    private Context context;
//    private ChildEventListener childEventListener;
//    private ArrayList<Article> articleArrayList = new ArrayList<>();
//                                                                           //  DatabaseReference
//    public FirenaseNewsListAdapter(FirebaseRecyclerOptions<Article> options, Query ref, OnStartDragListener DragListener,
//                                   Context ontext){
//        super(options);
//        newsReference = ref.getRef();
//        context = ontext;
//        childEventListener = newsReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                articleArrayList.add(snapshot.getValue(Article.class));
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull FirebaseNewsViewholder holder, int position, @NonNull Article model) {
//      holder.bindNewsAricles(model);
//      holder.img_news.setOnTouchListener(new View.OnTouchListener() {
//          @Override
//          public boolean onTouch(View view, MotionEvent motionEvent) {
//              if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN){
//                  onStartDragListener.onStartDrag(holder);
//              }
//              return  false;
//          }
//      });
//    }
//
//    @NonNull
//    @Override
//    public FirebaseNewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//      View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item_drag,parent,false);
//      return  new FirebaseNewsViewholder(view);
//    }
//
//    @Override
//    public boolean onItemMove(int fromPosition, int toPosition) {
//        Collections.swap(articleArrayList, fromPosition, toPosition);
//        notifyItemMoved(fromPosition, toPosition);
//        return false;
//    }
//
//    @Override
//    public void onItemDismiss(int position) {
//        articleArrayList.remove(position);
//        getRef(position).removeValue();
//    }
//    private void setIndexInFirebase() {
//        for (Article article : articleArrayList) {
//            int index = articleArrayList.indexOf(article);
//            DatabaseReference ref = getRef(index);
//           article.setIndex(Integer.toString(index));
//            ref.setValue(article);
//        }
//    }
//    @Override
//    public void stopListening() { super.stopListening();newsReference.removeEventListener(childEventListener); } }
//
//
//
