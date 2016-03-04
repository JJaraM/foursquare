package com.jjm.foursquare.entity;

import java.util.Set;

public class Venue {

    private String referenceId;
    private String name;
    private String url;
    private Double rating;

    private Contact contact;
    private Location location;
    private Set<Photo> photos;
    private Geocode geocode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    public Geocode getGeocode(){
        return geocode;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}