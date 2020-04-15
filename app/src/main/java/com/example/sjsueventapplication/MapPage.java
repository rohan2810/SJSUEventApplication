package com.example.sjsueventapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MapPage extends AppCompatActivity
{

    Button buttonConcert;
    Button buttonBasketball;
    Button buttonBowling;
    ImageView itemDescriptionImage;
    TextView textView;
    static ImageView picturesForEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_map);
        buttonConcert = findViewById(R.id.sjsuConcert);
        buttonBasketball = findViewById(R.id.sjsuBasketball);
        buttonBowling = findViewById(R.id.bowling);

        buttonConcert.setOnClickListener(new View.OnClickListener() {
            //this is for each button to go to the description page
            @Override
            public void onClick(View v) {
                Intent goTo = new Intent(v.getContext(), ItemDescription.class);
                goTo.putExtra("picture", R.drawable.sjsueventcenter);
                goTo.putExtra("description", "this is the event center");
                startActivity(goTo);
            }
        });

        buttonBowling.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                Intent goTo = new Intent(v.getContext(), ItemDescription.class);
                picturesForEvents = (ImageView)findViewById(R.drawable.bowling);
                //loads pictre url by left clicking and pressing copy path
                goTo.putExtra("picture", R.drawable.bowling);
                //Intent intent = getIntent();
               // String description = intent.getStringExtra("description");
                itemDescriptionImage=findViewById(R.id.itemDescriptionImage);
                textView=findViewById(R.id.textViewForConcert);
                itemDescriptionImage.setBackgroundResource(R.drawable.bowling);
                //textView.setText(description);
                goTo.putExtra("description", "this is the bowling alley");
                startActivity(goTo);
            }
        });

        buttonBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTo = new Intent(v.getContext(), ItemDescription.class);
                //loads pictre url by left clicking and pressing copy path
                goTo.putExtra("picture", R.drawable.sjsueventcenter);
                goTo.putExtra("description", "this is the basketball game");
                startActivity(goTo);
            }
        });

    }


}
