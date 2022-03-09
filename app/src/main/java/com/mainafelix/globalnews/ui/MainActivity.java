package com.mainafelix.globalnews.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.globalNewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    globalNewsAdapter adapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView searchView;
    @BindView(R.id.findNewsButton)
    Button findNewsButton1;
    
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);

            findNewsButton1.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if (view == findNewsButton1) {
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }

        }
    }


