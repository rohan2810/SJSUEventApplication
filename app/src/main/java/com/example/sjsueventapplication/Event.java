package com.example.sjsueventapplication;

public class Event {
    String id;
    String eventName;
    String information;
    String category;
    String location;

    public Event(String id, String eventName, String information, String category, String location) {
        this.id = id;
        this.eventName = eventName;
        this.information = information;
        this.category = category;
        this.location = location;
    }

    public String getid() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getInformation() {
        return information;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }
}
