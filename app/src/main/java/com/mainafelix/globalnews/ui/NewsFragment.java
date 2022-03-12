package com.mainafelix.globalnews.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mainafelix.globalnews.Constants;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.models.Article;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.imageView) ImageView img_news;
    @BindView(R.id.text_detail_author) TextView txt_author;
    @BindView(R.id.text_detail_title) TextView  txt_title;
    @BindView(R.id.text_detail_time) TextView txt_time;
    @BindView(R.id.text_detail_detail) TextView txt_detail;
    @BindView(R.id.text_detail_content) TextView txt_content;
     @BindView(R.id.Likebutton) Button like;
   private Article headlines;

        public  NewsFragment() {
            // Required empty public constructor
        }
        public static NewsFragment newInstance(Article article) {
            NewsFragment newsFragment = new NewsFragment();
            Bundle args = new Bundle();
            args.putParcelable("article", Parcels.wrap(article));
           newsFragment.setArguments(args);
            return newsFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            assert getArguments() != null;
          headlines = Parcels.unwrap(getArguments().getParcelable("article"));
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);


        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_content.setText(headlines.getContent());
        txt_detail.setText(headlines.getDescription());
        txt_time .setText(headlines.getPublishedAt());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
        like.setOnClickListener(this);

            return view;
        }

        @Override
        public void onClick(View v) {


            if (v == like ) {
                DatabaseReference newsref = FirebaseDatabase
                        .getInstance()
                        .getReference(Constants.FIREBASE_CHILD_NEWS);
                newsref.push().setValue(headlines);
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        }
        }

