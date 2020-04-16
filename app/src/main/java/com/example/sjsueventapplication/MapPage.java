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
    Button buttonBBQ;
    Button buttonVolleyball;


    ImageView pictureToAssign;
    private Button buttonLogout;
    private FirebaseAuth firebaseAuth;
    static int picture;
    static int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_map);
        buttonConcert = findViewById(R.id.buttonConcert);
        buttonConcert.setOnClickListener(this);

        buttonBasketball = findViewById(R.id.buttonBasketball);
        buttonBasketball.setOnClickListener(this);

        buttonBowling = findViewById(R.id.buttonBowling);
        buttonBowling.setOnClickListener(this);

        buttonBBQ = findViewById(R.id.buttonBBQ);
        buttonBBQ.setOnClickListener(this);

        buttonVolleyball = findViewById(R.id.buttonVolleyball);
        buttonVolleyball.setOnClickListener(this);

        buttonLogout = (Button) findViewById(R.id.logoutButton);
        buttonLogout.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

        images = new int[4];
        images[0] = R.drawable.bowling;
        images[1] = R.drawable.sjsueventcenter;

        //images[2] = R.drawable.;
        //images[3] = R.drawable;
        //images[4] = R.drawable;

        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

       /*  buttonConcert.setOnClickListener(new View.OnClickListener()
        {
            //this is for each button to go to the description page
            @Override
            public void onClick(View v)
            {
                Intent goTo = new Intent(v.getContext(), ItemDescription.class);
               // goTo.putExtra("picture", R.drawable.sjsueventcenter);
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
                //goTo.putExtra("picture", R.drawable.bowling);
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
               // goTo.putExtra("picture", R.drawable.sjsueventcenter);
                goTo.putExtra("description", "this is the basketball game");
                startActivity(goTo);
            }
        });*/
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

        if(view == buttonBowling)
        {
            picture = 0;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "Hey Spartans! We are having a Bowling " +
                    "Tournament in the Student Union on September 25th at 7pm. Come to the Student " +
                    "Union to RSVP your team for $5 a person. The winning team will recieve" +
                    " free SJSU bowling shirts!");
            startActivity(goTo);
        }

        if(view == buttonConcert)
        {
            picture = 1;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "this is the event center");
            startActivity(goTo);
        }

        if(view == buttonBasketball)
        {
            picture = 1;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "this is for the basketball game");
            startActivity(goTo);
        }

        if(view == buttonBBQ)
        {
            picture = 1;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "Come and enjoy a BBQ with your fellow " +
                    "Spartans at the new SRAC!");
            startActivity(goTo);
        }

        if(view == buttonVolleyball)
        {
            picture = 1;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "this is for the basketball game");
            startActivity(goTo);
        }
    }
}
