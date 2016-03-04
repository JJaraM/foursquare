package com.jjm.foursquare.entity;


public class Contact {

    private String phone;
    private String facebookUsername;
    private String facebookName;
    private Venue venue;

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }
    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getFacebookName() {
        return facebookName;
    }
    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public Venue getVenue() {
        return venue;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
