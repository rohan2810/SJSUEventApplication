package com.example.sjsueventapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDescription extends AppCompatActivity {

    ImageView itemDescriptionImage;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        String pictureURI = intent.getStringExtra("picture");

        ImageView view = MapPage.picturesForEvents;

        itemDescriptionImage=findViewById(R.id.itemDescriptionImage);
        textView=findViewById(R.id.textViewForConcert);


        //itemDescriptionImage.setBackgroundResource(R.drawable.);
        textView.setText(description);
    }
}
