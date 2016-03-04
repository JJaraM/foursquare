package com.jjm.foursquare.service.impl;

import com.jjm.foursquare.entity.Photo;
import com.jjm.foursquare.factory.PhotoFactoryFoursquare;
import com.jjm.foursquare.repository.Connector;
import com.jjm.foursquare.service.PhotoServiceFoursqure;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service(value = "photoServiceFoursquare")
public class PhotoServiceFoursquareImpl implements PhotoServiceFoursqure {

    @Resource private Connector connector;
    @Resource private PhotoFactoryFoursquare factory;

    @Override
    public Set<Photo> fetchByPlaceReferenceId(String referenceId) {
        JSONObject places = connector.get("venues/"+referenceId+"/photos");
        JSONObject response = JSONObject.class.cast(places.get("response"));
        JSONObject photos = JSONObject.class.cast(response.get("photos"));
        JSONArray items = JSONArray.class.cast(photos.get("items"));
        return IntStream.range(0, items.length()).parallel().mapToObj(index -> {
            Photo photo = factory.create((JSONObject) items.get(index));
            return photo;
        }).collect(Collectors.toSet());
    }
}
