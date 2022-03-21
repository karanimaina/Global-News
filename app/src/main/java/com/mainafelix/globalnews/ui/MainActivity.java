package com.mainafelix.globalnews.ui;



import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mainafelix.globalnews.Constants;
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
    @BindView(R.id.savedNewsButton)
    Button savedNews;
    Button port,land;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String selectedCountry ="";
    //  private SharedPreferences sharedPreferences;
    // private SharedPreferences.Editor editor;
    private DatabaseReference databaseReference;
    private ValueEventListener NewsValueEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        databaseReference = FirebaseDatabase
                .getInstance().getReference().child(Constants.PREFERENCES_KEY_NEWS);
        NewsValueEventListener= databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot newsSnapshot : snapshot.getChildren()){
                    selectedCountry = spinner.getSelectedItem().toString();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

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
        port = findViewById(R.id.portraitMain);
        land = findViewById(R.id.LandScapeMain);
        port.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
        land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });
        findNewsButton1.setOnClickListener(this);
        savedNews.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == findNewsButton1) {
            selectedCountry = spinner.getSelectedItem().toString();
            Log.d("country",selectedCountry);
            saveCountryToFirebase(selectedCountry);
//            if (!(selectedCountry).equals(null)){
//                addToSharedPreferences(selectedCountry);
//            }

            Intent intent = new Intent(this, NewsActivity.class);
            intent.putExtra("country", selectedCountry);
            startActivity(intent);

        }
        if (view == savedNews){
            Intent intent = new Intent(MainActivity.this,savedNewsListActivity.class);
            startActivity(intent);
        }
    }
    public void saveCountryToFirebase(String selectedCountry) {
        databaseReference.push().setValue(selectedCountry);
    }

    //    private void addToSharedPreferences(String selectedCountry) {
//     //   editor.putString(Constants.PREFERENCES_KEY_NEWS, selectedCountry).apply();
//    }
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseReference.removeEventListener(NewsValueEventListener);
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
