package com.example.sjsueventapplication;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class ListEvent extends AppCompatActivity{


    ListView listViewDisplay;
    ArrayList<String> eventList;
    ArrayAdapter<String> adapter;
    private DatabaseReference databaseEvents;
    private FirebaseDatabase mFirebaseDatabase;
    Event event;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);
       event = new Event();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseEvents = mFirebaseDatabase.getReference().child("Event");
        listViewDisplay = (ListView) findViewById(R.id.listViewDisplay);
        eventList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,R.layout.list_layout,R.id.viewName,eventList);

        databaseEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    event = eventSnapshot.getValue(Event.class);
                    eventList.add(event.getEventName().toString());
                    eventList.add(event.getId().toString());
                    eventList.add(event.getCategory().toString());
                    eventList.add(event.getInformation().toString());
                    eventList.add(event.getLocation().toString());

                }
                listViewDisplay.setAdapter(adapter);
//                EventListing adapter = new EventListing(ListEvent.this,eventList);
//                listViewDisplay.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


}
    }

