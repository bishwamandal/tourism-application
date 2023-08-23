package com.example.tourismapp.Class;

public class NewPlaces {

    String destination_name, location, description;

    public NewPlaces() {
    }

    public NewPlaces(String destination_name, String location, String description) {
        this.destination_name = destination_name;
        this.location = location;
        this.description = description;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
