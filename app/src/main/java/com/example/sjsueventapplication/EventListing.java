//package com.example.sjsueventapplication;
//
//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EventListing extends ArrayAdapter<Event> {
//    private Activity context;
//    private ArrayList<String> events;
//
//    public EventListing(Activity context, ArrayList<String> events) {
//        super(context,R.layout.list_layout,events);
//        this.context = context;
//        this.events = events;
//        System.out.println("Constructor Called: Event Listing");
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//        System.out.println("Method Called: getView :EventListing");
//        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
//        TextView textViewId = (TextView) listViewItem.findViewById(R.id.viewId);
//        TextView textViewName = (TextView) listViewItem.findViewById(R.id.viewName);
//        TextView textViewLocation = (TextView) listViewItem.findViewById(R.id.viewLocation);
//        TextView textViewCategory = (TextView) listViewItem.findViewById(R.id.viewCategory);
//        TextView textViewInfo = (TextView) listViewItem.findViewById(R.id.viewInfo);
//
//
//        Event event = events.get(position);
//        textViewId.setText(event.getId().toString());
//        textViewName.setText(event.getEventName().toString());
//        textViewLocation.setText(event.getLocation());
//        textViewCategory.setText(event.getCategory());
//        textViewInfo.setText(event.getInformation());
//
//        return listViewItem;
//    }
//}
