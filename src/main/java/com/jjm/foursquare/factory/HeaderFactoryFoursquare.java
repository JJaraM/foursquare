package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Header;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class HeaderFactoryFoursquare {

    public Header create(JSONObject jsonObject) {
        Header header = new Header();
        header.setHeaderFullLocation(jsonObject.getString("headerFullLocation"));
        header.setHeaderLocation(jsonObject.getString("headerLocation"));
        header.setHeaderLocationGranularity(jsonObject.getString("headerLocationGranularity"));
        return header;
    }
}
