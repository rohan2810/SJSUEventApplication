package com.example.sjsueventapplication;

public class Event {
    String id;
    String eventName;
    String information;
    String category;
    String location;

    public Event() {
    }

    public Event(String id, String eventName, String information, String category, String location) {
        this.id = id;
        this.eventName = eventName;
        this.information = information;
        this.category = category;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
