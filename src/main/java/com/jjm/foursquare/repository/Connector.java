package com.jjm.foursquare.repository;

import com.jjm.foursquare.domain.Parameter;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public interface Connector {

    String getUrl(String path, Parameter... parameters);
    RestTemplate getRestTemplate();
    JSONObject get(String path, Parameter... parameters);

}
