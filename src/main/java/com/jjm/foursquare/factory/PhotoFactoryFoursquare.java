package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Photo;
import com.jjm.foursquare.utils.JSONObjectUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component(value = "photoFactoryFoursquare")
public class PhotoFactoryFoursquare {

    public Photo create(JSONObject jsonObject) {
        Photo photo = new Photo();
        photo.setReferenceId(JSONObjectUtils.getString(jsonObject, "id"));
        photo.setPrefix(JSONObjectUtils.getString(jsonObject, "prefix"));
        photo.setSuffix(JSONObjectUtils.getString(jsonObject, "suffix"));
        photo.setHeight(JSONObjectUtils.getDouble(jsonObject, "height"));
        photo.setWidth(JSONObjectUtils.getDouble(jsonObject, "width"));
        return photo;
    }
}
