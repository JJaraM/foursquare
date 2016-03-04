package com.jjm.foursquare.service;

import com.jjm.foursquare.entity.Photo;
import java.util.Set;

public interface PhotoServiceFoursqure {
    Set<Photo> fetchByPlaceReferenceId(String referenceId);
}
