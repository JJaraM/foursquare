package com.jjm.foursquare.entity;

import java.util.Set;

public class Group<T> {

    private Set<T> items;

    public Set<T> getItems() {
        return items;
    }

    public void setItems(Set<T> items) {
        this.items = items;
    }

    public Object addItem(T item) {
        getItems().add(item);
        return item;
    }
}
