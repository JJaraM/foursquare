package com.jjm.foursquare.factory;

import com.jjm.foursquare.entity.Contact;
import com.jjm.foursquare.utils.JSONObjectUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component(value = "contactFactoryFoursquare")
public class ContactFactoryFoursquare {

    public Contact create(JSONObject jsonObject) {
        Contact contact = new Contact();
        contact.setPhone(JSONObjectUtils.getString(jsonObject, "phone"));
        contact.setFacebookName(JSONObjectUtils.getString(jsonObject, "facebookName"));
        contact.setFacebookUsername(JSONObjectUtils.getString(jsonObject, "facebookUsername"));
        return contact;
    }
}
