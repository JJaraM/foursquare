package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Meta;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class MetaFactory {

    public Meta create(JSONObject jsonObject) {
        JSONObject metaJson = JSONObject.class.cast(jsonObject.get("meta"));
        Meta meta = new Meta();
        meta.setCode(metaJson.getInt("code"));
        meta.setRequestId(metaJson.getString("requestId"));
        return meta;
    }
}
