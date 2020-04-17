package com.example.sjsueventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventList extends AppCompatActivity implements View.OnClickListener
{
    private Button bowlingButton;
    private Button mapButton;
    private Button concertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        bowlingButton = (Button)findViewById(R.id.buttonBowling);
        bowlingButton.setOnClickListener(this);
        mapButton = (Button)findViewById(R.id.mapButton);
        mapButton.setOnClickListener(this);
        concertButton = (Button)findViewById(R.id.concertButton);
        concertButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view == bowlingButton)
        {
            MapPage.picture = 0;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "Hey Spartans! We are having a Bowling " +
                    "Tournament in the Student Union on September 25th at 7PM. Come to the Student " +
                    "Union to RSVP your team for $5 a person. The winning team will recieve" +
                    " free SJSU bowling shirts!");
            startActivity(goTo);
        }
        if (view == concertButton)
        {
            MapPage.picture = 1;
            Intent goTo = new Intent(view.getContext(), ItemDescription.class);
            goTo.putExtra("description", "San Jose State is hosting a free concert for" +
                    " all students on October 30th at 9PM. Tickets will be distributed at the Event Center" +
                    " ticket booth to students with a valid student ID. The deadline to get your " +
                    "free ticket is October 28th. See you there!");
            startActivity(goTo);
        }
        if (view == mapButton)
        {
            Intent goTo = new Intent(view.getContext(), MapPage.class);
            startActivity(goTo);
        }
    }
}
