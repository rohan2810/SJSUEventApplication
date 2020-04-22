package com.example.sjsueventapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MapPage extends AppCompatActivity implements View.OnClickListener
{
    private Button buttonConcert;
    private Button buttonBasketball;
    private Button buttonBowling;
    private Button buttonBBQ;
    private Button buttonVolleyball;
    private Button buttonFilter;
    private Button buttonLogout;
    private Button addEvents;
    private Button listEvents;
    private FirebaseAuth firebaseAuth;
    static int picture;
    static int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_map);
        addEvents = findViewById(R.id.addEvents);
        addEvents.setOnClickListener(this);
        listEvents = findViewById(R.id.listEvents);
        listEvents.setOnClickListener(this);
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

        buttonLogout = findViewById(R.id.logoutButton);
        buttonLogout.setOnClickListener(this);

        buttonFilter = findViewById(R.id.buttonFilter);
        buttonFilter.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

        images = new int[5];
        images[0] = R.drawable.bowling;
        images[1] = R.drawable.concert;
        images[2] = R.drawable.sjsueventcenter;
        images[3] = R.drawable.pool;
        images[4] = R.drawable.volleyball;

        if (firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this, RegisterOrLogin.class));
        }
    }

    @Override
    public void onClick(View view)
    {
        if (view == buttonLogout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, RegisterOrLogin.class));
        }
        if (view == buttonBowling)
        {
            picture = 0;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "Hey Spartans! We are having a Bowling " +
                    "Tournament in the Student Union on September 25th at 7PM. Come to the Student " +
                    "Union to RSVP your team for $5 a person. The winning team will recieve" +
                    " free SJSU bowling shirts!");
            startActivity(goTo);
        }
        if (view == buttonConcert)
        {
            picture = 1;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "San Jose State is hosting a free concert for" +
                    " all students on October 30th, at 9PM. Tickets will be distributed at the Event Center" +
                    " ticket booth to students with a valid student ID. The deadline to get your " +
                    "free ticket is October 28th. See you there!");
            startActivity(goTo);
        }
        if (view == buttonBasketball)
        {
            picture = 2;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "The Spartan Basketball team is having a " +
                    "game against UC Berkeley Saturday September 10th, at 7PM. Come support our players" +
                    " and enjoy free pizza and churros! Spartan Up!");
            startActivity(goTo);
        }
        if (view == buttonBBQ)
        {
            picture = 3;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "Come and enjoy a BBQ with your fellow " +
                    "Spartans at the new SRAC! We will be cooking free hotdogs and hamburgers from " +
                    "12PM to 3PM by the pool.");
            startActivity(goTo);
        }
        if (view == buttonVolleyball)
        {
            picture = 4;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "The Women's Volleyball team is having their " +
                    "first game of the season against UC Santa Cruz Friday September 17th, at 6PM. " +
                    "We will be handing out free shirts and wristbands to the first 100 students" +
                    " who come cheer on our volleyball team. Spartan Up!");
            startActivity(goTo);
        }
        if (view == buttonFilter)
        {
            Intent goTo = new Intent(view.getContext(), EventList.class);
            startActivity(goTo);
        }
        if(view == addEvents)
        {
            Intent goTo = new Intent(view.getContext(), DatabaseActivity.class);
            startActivity(goTo);
        }
        if(view == listEvents)
        {
            Intent goTo = new Intent(view.getContext(), ListEvent.class);
            startActivity(goTo);
        }
    }
}
