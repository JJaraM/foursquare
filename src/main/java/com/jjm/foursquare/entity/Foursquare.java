package com.jjm.foursquare.entity;

import java.util.List;

public class Foursquare {

    private Meta meta;
    private Response response;
    private List<Group> groups;

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
