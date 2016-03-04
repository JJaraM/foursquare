package com.jjm.foursquare.repository.impl;

import com.jjm.foursquare.domain.Parameter;
import com.jjm.foursquare.init.FoursquareApplication;
import com.jjm.foursquare.repository.Connector;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component(value = "connectorFoursquare")
public class ConnectorFoursquare implements Connector {

    private UriComponentsBuilder getBuilder(String path, Parameter... parameters) {
        UriComponentsBuilder builder = getUriComponentsBuilder(path, parameters);
        builder.queryParam("client_id", FoursquareApplication.getInstance().getClientId());
        builder.queryParam("client_secret", FoursquareApplication.getInstance().getClientSecret());
        builder.queryParam("v", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        builder.queryParam("limit", 3000);
        return builder;
    }

    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            protected boolean hasError(HttpStatus statusCode) {
                return false;
            }
        });
        return restTemplate;
    }

    @Override
    public JSONObject get(String path, Parameter... parameters) {
        return new JSONObject(getRestTemplate().getForObject(getBuilder(path, parameters).build().encode().toUri(), String.class));
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Override
    public String getUrl(String path, Parameter... parameters) {
        return getUriComponentsBuilder(path, parameters).build().encode().toUriString();
    }

    private UriComponentsBuilder getUriComponentsBuilder(String path, Parameter... parameters) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl(path));
        for (Parameter parameter : parameters) {
            builder.queryParam(parameter.getName(), parameter.getValue());
        }
        return builder;
    }

    private String getUrl(String path) {
        return "https://api.foursquare.com/v2/".concat(path);
    }
}
