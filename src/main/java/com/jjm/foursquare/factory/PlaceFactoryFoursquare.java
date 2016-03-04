package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Photo;
import com.jjm.foursquare.entity.Venue;
import com.jjm.foursquare.utils.JSONObjectUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component(value = "placeFactoryFoursquare")
public class PlaceFactoryFoursquare {

    @Resource private LocationFactoryFoursquare locationFactoryFoursquare;
    @Resource private ContactFactoryFoursquare contactFactoryFoursquare;
    @Resource private PhotoFactoryFoursquare photoFactoryFoursquare;

    public Venue create(JSONObject jsonObject) {
        Venue place = new Venue();
        JSONObject venue = jsonObject.getJSONObject("venue");
        place.setReferenceId(JSONObjectUtils.getString(venue, "id"));
        place.setName(JSONObjectUtils.getString(venue, "name"));
        place.setUrl(JSONObjectUtils.getString(venue, "url"));

        //Photos
        Set<Photo> photos = new HashSet<>();
        JSONObject jsonObjectPhotos = JSONObject.class.cast(venue.get("photos"));
        JSONObject groups = JSONObject.class.cast(jsonObjectPhotos.getJSONArray("groups").get(0));
        JSONArray items = groups.getJSONArray("items");
        photos.add(photoFactoryFoursquare.create(items.getJSONObject(0)));
        place.setPhotos(photos);

        place.setLocation(locationFactoryFoursquare.create(JSONObject.class.cast(venue.get("location"))));
        place.setContact(contactFactoryFoursquare.create(JSONObject.class.cast(venue.get("contact"))));
        return place;
    }
}
