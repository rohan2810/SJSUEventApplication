package com.example.sjsueventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseDatabase mFirebaseDatabase;
//    private DatabaseReference databaseCategory;
//    private DatabaseReference databaseLocation;
    private DatabaseReference databaseEvents;

//    ListView listViewEvents;
//    List<Event> eventList;

    EditText info;
    EditText name;
    Button button;
    Spinner spinnerCategory;
    Spinner spinnerLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
       databaseEvents = mFirebaseDatabase.getReference("Event");
       // databaseCategory = FirebaseDatabase.getInstance().getReference("Event");
        //databaseEvents = FirebaseDatabase.getInstance().getReference("Event");
        //databaseLocation = FirebaseDatabase.getInstance().getReference("location");
        //databaseCategory = mFirebaseDatabase.getReference().child("messages");
        name = (EditText) findViewById(R.id.name);
        info = (EditText) findViewById(R.id.info);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        spinnerCategory = (Spinner) findViewById(R.id.Category);
        spinnerLocation = (Spinner) findViewById(R.id.Location);

//        listViewEvents = (ListView) findViewById(R.id.listViewDisplay);  //check this one
//        eventList = new ArrayList<>();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        databaseEvents.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                eventList.clear();
//
//                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()){
//                    Event event = eventSnapshot.getValue(Event.class);
//                    eventList.add(event);
//                }
//
//                EventListing adapter = new EventListing(DatabaseActivity.this,eventList);
//                listViewEvents.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

    private void addinfo(){
        System.out.print("Here1");
        String information = info.getText().toString().trim();
        String eventName  = name.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString();
        String location = spinnerLocation.getSelectedItem().toString();

        if(!TextUtils.isEmpty(information)){

            String id = databaseEvents.push().getKey();
            Event event  = new Event(id,eventName,information,category,location);

            databaseEvents.child(id).setValue(event);

            Toast.makeText(this,"Event added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"You should enter information",Toast.LENGTH_LONG).show();
        }
//    }
    }

    @Override
    public void onClick(View view) {
        if(view == button){
        System.out.print("Here");
               addinfo();}
    }
}
