package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Location;
import com.jjm.foursquare.utils.JSONObjectUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component(value = "locationFactoryFoursquare")
public class LocationFactoryFoursquare {

    public Location create(JSONObject jsonObject) {
        Location location = new Location();
        location.setAddress(JSONObjectUtils.getString(jsonObject, "address"));
        location.setCrossStreet(JSONObjectUtils.getString(jsonObject, "crossStreet"));
        location.setPostalCode(JSONObjectUtils.getString(jsonObject, "postalCode"));
        location.setCc(JSONObjectUtils.getString(jsonObject, "cc"));
        location.setCity(JSONObjectUtils.getString(jsonObject, "city"));
        location.setState(JSONObjectUtils.getString(jsonObject, "state"));
        location.setCountry(JSONObjectUtils.getString(jsonObject, "country"));
        location.setLatitude(JSONObjectUtils.getDouble(jsonObject, "lat"));
        location.setLongitude(JSONObjectUtils.getDouble(jsonObject, "lng"));
        return location;
    }
}
