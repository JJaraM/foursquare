package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Category;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactoryFoursquare {
    public Category create(JSONArray json) {
        Category category = new Category();
        category.setName(json.getJSONObject(0).getString("name"));
        category.setId(json.getJSONObject(0).getString("id"));
        return category;
    }
}
