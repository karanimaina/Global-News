package com.mainafelix.globalnews;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mainafelix.globalnews.models.Article;
import com.mainafelix.globalnews.ui.NewsDetailActivity;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlobalViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
    TextView text_title,text_source;
    ImageView img_headline;
    CardView cardView;
    private List<Article>headlines;
    private Context context;


    public GlobalViewHolder(@NonNull View itemView) {
        super(itemView);
        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_source);
        img_headline= itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);
        context = itemView.getContext();

    }

    @Override
    public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(context, NewsDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("article", Parcels.wrap(headlines));
            context.startActivity(intent);
        }
    }
