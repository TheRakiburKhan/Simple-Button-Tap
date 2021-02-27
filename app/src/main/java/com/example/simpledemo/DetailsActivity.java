package com.example.simpledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = (TextView) findViewById(R.id.txt_view);

        Intent intent = getIntent();
        String string = intent.getStringExtra("from");

        textView.setText("Details comes from "+string);
    }
}