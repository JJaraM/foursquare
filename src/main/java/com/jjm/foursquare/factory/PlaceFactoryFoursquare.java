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
    @Resource private CategoryFactoryFoursquare categoryFactoryFoursquare;

    public Venue create(JSONObject jsonObject) {
        Venue place = new Venue();
        JSONObject venue = jsonObject.getJSONObject("venue");
        place.setReferenceId(JSONObjectUtils.getString(venue, "id"));
        place.setName(JSONObjectUtils.getString(venue, "name"));
        place.setUrl(JSONObjectUtils.getString(venue, "url"));
        place.setRating(JSONObjectUtils.getDouble(venue, "rating"));
        //Photos
        JSONObject jsonObjectPhotos = JSONObject.class.cast(venue.get("photos"));
        JSONArray groupsArray = jsonObjectPhotos.getJSONArray("groups");
        if (groupsArray != null && groupsArray.length() > 0) {
            Set<Photo> photos = new HashSet<>();
            JSONObject groups = JSONObject.class.cast(groupsArray.get(0));
            JSONArray items = groups.getJSONArray("items");
            photos.add(photoFactoryFoursquare.create(items.getJSONObject(0)));
            place.setPhotos(photos);
        }

        place.setLocation(locationFactoryFoursquare.create(JSONObject.class.cast(venue.get("location"))));
        place.setContact(contactFactoryFoursquare.create(JSONObject.class.cast(venue.get("contact"))));
        place.setCategory(categoryFactoryFoursquare.create(JSONArray.class.cast(venue.get("categories"))));
        return place;
    }
}
