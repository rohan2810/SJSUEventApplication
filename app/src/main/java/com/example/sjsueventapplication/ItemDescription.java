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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");

        //from the description page
        imageView = findViewById(R.id.itemDescriptionImage);
        textView = findViewById(R.id.textDescription);

        //changed from set background resource
        //imageView.setImageResource(R.drawable.sjsueventcenter);
        imageView.setImageResource(MapPage.images[MapPage.picture]);
        textView.setText(description);
    }
}
