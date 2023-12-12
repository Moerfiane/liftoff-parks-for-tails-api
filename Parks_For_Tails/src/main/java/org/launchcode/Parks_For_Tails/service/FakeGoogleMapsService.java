package org.launchcode.Parks_For_Tails.service;

import com.google.maps.model.PlacesSearchResult;

//A fake implementation that mimics the behavior of GoogleMapsService. Instead of making real API calls, it returns predefined responses.
// This allows testing how your service handles various scenarios (like specific queries)
public class FakeGoogleMapsService {
    // This class acts as a fake implementation of the Google Maps API

    public PlacesSearchResult[] searchParks(String query) {
        // Returns a fake response for a specific query ("central park")
        if ("central park".equals(query)) {
            PlacesSearchResult result = new PlacesSearchResult();
            result.name = "Central Park";
            result.formattedAddress = "New York, NY, USA";
            return new PlacesSearchResult[]{result};
        }
        // Returns an empty array for other queries
        return new PlacesSearchResult[0];
    }
}
