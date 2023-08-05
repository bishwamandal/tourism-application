package com.example.tourismapp.Domains;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title;
    private String location;
    private String pic;

    public PopularDomain(String title, String location, String pic) {
        this.title = title;
        this.location = location;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
