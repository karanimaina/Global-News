package com.mainafelix.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    //holds  our find restaurant  Button
    @BindView(R.id.findNewsButton)
    Button FindRestaurantsButton;
    @BindView(R.id.locationEditText)
    EditText LocationEditText;
    @BindView(R.id.appNameTextView)
    TextView ppNameTextView;
