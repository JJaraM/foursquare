package com.jjm.foursquare.service;

import com.jjm.foursquare.entity.Response;
import com.jjm.foursquare.entity.Venue;

public interface PlaceServiceFoursquare {
    Response<Venue> fetchNearPlacesByLocationName(String location);
}
