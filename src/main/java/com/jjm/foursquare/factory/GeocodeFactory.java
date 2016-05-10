package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Geocode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class GeocodeFactory {

    public Geocode create(JSONObject jsonObject) {
        Geocode geocode = new Geocode();
        geocode.setCc(jsonObject.getString("cc"));
        geocode.setDisplayString(jsonObject.getString("displayString"));
        geocode.setWhere(jsonObject.getString("where"));
        return geocode;
    }
}
