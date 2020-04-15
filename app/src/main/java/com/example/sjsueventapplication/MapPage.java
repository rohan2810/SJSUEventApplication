package com.example.sjsueventapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MapPage extends AppCompatActivity implements View.OnClickListener
{
    Button buttonConcert;
    Button buttonBasketball;
    Button buttonBowling;
    ImageView pictureToAssign;
    private Button buttonLogout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_map);
        buttonConcert = findViewById(R.id.sjsuConcert);
        buttonBasketball = findViewById(R.id.sjsuBasketball);
        buttonBowling = findViewById(R.id.bowling);
        buttonLogout = (Button) findViewById(R.id.logoutButton);
        buttonLogout.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

         buttonConcert.setOnClickListener(new View.OnClickListener()
        {
            //this is for each button to go to the description page
            @Override
            public void onClick(View v)
            {
                Intent goTo = new Intent(v.getContext(), ItemDescription.class);
                goTo.putExtra("picture", R.drawable.sjsueventcenter);
                goTo.putExtra("description", "this is the event center");
                startActivity(goTo);
            }
        });

        buttonBowling.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent goTo = new Intent(v.getContext(), ItemDescription.class);
                //loads pictre url by left clicking and pressing copy path
                goTo.putExtra("picture", R.drawable.bowling);
                goTo.putExtra("description", "this is the bowling alley");
                startActivity(goTo);
            }
        });

        buttonBasketball.setOnClickListener(new View.OnClickListener()
        {
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

    @Override
    public void onClick(View view)
    {
        if(view == buttonLogout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}
