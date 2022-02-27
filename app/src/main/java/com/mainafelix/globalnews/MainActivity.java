package com.mainafelix.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    //holds  our find restaurant  Button
    @BindView(R.id.findNewsButton)
    Button FindNewsButton;
    @BindView(R.id.locationEditText)
    EditText LocationEditText;
    @BindView(R.id.appNameTextView)
    TextView ppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//runs all the default behaviours of an activity
        setContentView(R.layout.activity_main);//tells the activity which layout to use which is activity_main
        LocationEditText =(EditText) findViewById(R.id.locationEditText);
        ButterKnife.bind(this);

        FindNewsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == FindNewsButton) {
            String News = LocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
            intent.putExtra("News", News);
            startActivity(intent);
        }}
}

