package com.mainafelix.globalnews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.util.ItemTouchHelperAdapter;
import com.mainafelix.globalnews.util.OnStartDragListener;

public class FirenaseNewsListAdapter extends FirebaseRecyclerAdapter<Article,FirebaseNewsViewholder> implements ItemTouchHelperAdapter {
    private DatabaseReference newsReference;
    private OnStartDragListener onStartDragListener;
    private Context context;

    public FirenaseNewsListAdapter(FirebaseRecyclerOptions<Article> options,DatabaseReference ref,OnStartDragListener onStartDragListener,
                                   Context context){
        super(options);
        newsReference = ref.getRef();
        onStartDragListener = onStartDragListener;
        context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseNewsViewholder holder, int position, @NonNull Article model) {
      holder.bindNewsAricles(model);
    }

    @NonNull
    @Override
    public FirebaseNewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item_drag,parent,false);
      return  new FirebaseNewsViewholder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}


