package com.example.simpledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.btn_1);
        button2 = (Button) findViewById(R.id.btn_2);
        button3 = (Button) findViewById(R.id.btn_3);

        //Button1 is handled from XML

        //This is another way to set on click action
        button2.setOnClickListener(this);

        //This is another way but not preferred by me
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                internalOnClickAction(view);
            }
        });
    }

    @SuppressLint("ShowToast")
    public void clickFromXML(View view) {
       //Toast.makeText(getApplicationContext(), "Button 1 pressed", Toast.LENGTH_LONG).show();
        nextActivity("Button 1");
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btn_2:
               //Toast.makeText(getApplicationContext(), "Button 2 pressed", Toast.LENGTH_LONG).show();
                nextActivity("Button 2");
            default:
                break;
        }
    }

    private void internalOnClickAction(View button) {
        //Toast.makeText(getApplicationContext(), "Button 3 pressed", Toast.LENGTH_LONG).show();
        nextActivity("Button 3");
    }

    private void nextActivity(String string) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("from", string);
        startActivity(intent);
    }
}