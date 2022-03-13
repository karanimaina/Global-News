package com.mainafelix.globalnews.ui;

//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.mainafelix.globalnews.MySpinnerSelectedListener;
//import com.mainafelix.globalnews.R;
//import com.mainafelix.globalnews.globalNewsAdapter;
//
//import java.sql.Struct;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    RecyclerView recyclerView;
//    globalNewsAdapter adapter;
//    ProgressDialog dialog;
//    Button b1, b2, b3, b4, b5, b6, b7;
//    SearchView searchView;
//    Spinner spinner;
//    @BindView(R.id.savedNewsButton) Button savedNewsButton;
//    @BindView(R.id.findNewsButton) Button findNewsButton1;
//    int positionOfSelectedDataFromSpinner;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        Spinner spinner = findViewById(R.id.spinner);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                parent.setSelection(1);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
//        spinner.setOnItemSelectedListener(new MySpinnerSelectedListener());
////add this
//        savedNewsButton.setOnClickListener(this);
//        findNewsButton1.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view) {
//        if (view == findNewsButton1) {
//            Intent intent = new Intent(this, NewsActivity.class);
////            intent.putExtra("position", country);
//            startActivity(intent);
//        }else {
//            if (view == savedNewsButton) {
//                Intent intent = new Intent(MainActivity.this, savedNewsListActivity.class);
//                startActivity(intent);
//            }
//        }}
//}


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mainafelix.globalnews.MySpinnerSelectedListener;
import com.mainafelix.globalnews.R;
import com.mainafelix.globalnews.globalNewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    globalNewsAdapter adapter;
    ProgressDialog dialog;
    Button b1, b2, b3, b4, b5, b6, b7;
    SearchView searchView;
   @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.findNewsButton)
    Button findNewsButton1;
    int positionOfSelectedDataFromSpinner;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String selectedCountry ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //display welcome message
            }
        };
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

//add this
        findNewsButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == findNewsButton1) {
            selectedCountry = spinner.getSelectedItem().toString();
            Log.d("country",selectedCountry);
            Intent intent = new Intent(this, NewsActivity.class);
           intent.putExtra("country", selectedCountry);
            startActivity(intent);

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}

