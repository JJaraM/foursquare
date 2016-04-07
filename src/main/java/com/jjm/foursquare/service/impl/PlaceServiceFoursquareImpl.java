package com.jjm.foursquare.service.impl;

import com.jjm.foursquare.domain.Parameter;
import com.jjm.foursquare.entity.*;
import com.jjm.foursquare.factory.GeocodeFactory;
import com.jjm.foursquare.factory.MetaFactory;
import com.jjm.foursquare.factory.PlaceFactoryFoursquare;
import com.jjm.foursquare.repository.Connector;
import com.jjm.foursquare.service.PlaceServiceFoursquare;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service(value = "placeServiceFoursquare")
public class PlaceServiceFoursquareImpl implements PlaceServiceFoursquare {

    @Resource private MetaFactory metaFactory;
    @Resource private GeocodeFactory geocodeFactory;

    @Resource private Connector connector;
    @Resource private PlaceFactoryFoursquare factory;

    @Override
    public Response<Venue> fetchNearPlacesByLocationName(String location) {
        JSONObject jsonObject = connector.get("venues/explore", new Parameter("near", location), new Parameter("venuePhotos", "1"));
        JSONObject jsonResponse = JSONObject.class.cast(jsonObject.get("response"));
        //Response
        Response<Venue> response = new Response();
        response.setMeta(metaFactory.create(jsonObject));
        //Geocode
        response.setGeocode(geocodeFactory.create(jsonResponse));
        //Items
        JSONArray groups = JSONArray.class.cast(jsonResponse.get("groups"));
        JSONArray items = JSONObject.class.cast(groups.get(0)).getJSONArray("items");
        response.setItems(IntStream.range(0, items.length()).parallel().mapToObj(
                index -> factory.create((JSONObject) items.get(index))
        ).collect(Collectors.toSet()));
        return response;
    }


}
