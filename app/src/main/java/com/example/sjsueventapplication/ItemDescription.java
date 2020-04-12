package com.example.sjsueventapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDescription extends AppCompatActivity
{
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        String pictureURI = intent.getStringExtra("picture");

        imageView=findViewById(R.id.concertEvent);
        textView=findViewById(R.id.textViewForConcert);


        imageView.setBackgroundResource(R.drawable.sjsueventcenter);
        textView.setText(description);
    }
}
