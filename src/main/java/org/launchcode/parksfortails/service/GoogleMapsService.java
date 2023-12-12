package org.launchcode.Parks_For_Tails.service;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

//This is the actual service class in your application that interacts with the Google Maps API.
// It sends queries and processes responses from the API.

@Service // Marks this class as a Spring service component
public class GoogleMapsService {

    @Value("${google.maps.api-key}") // Injects the API key from application properties
    private String apiKey;

    public PlacesSearchResult[] searchParks(String query) throws InterruptedException, ApiException, IOException {
        // Initializes the GeoApiContext with the API key
        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();

        // Calls the method that makes the actual API request
        return callTextSearchQuery(context, query);
    }

    // Method that makes the API call; could be adjusted for testability or different implementations
    protected PlacesSearchResult[] callTextSearchQuery(GeoApiContext context, String query)
            throws InterruptedException, ApiException, IOException {
        // Creates and sends a text search request to the Google Maps API
        TextSearchRequest request = PlacesApi.textSearchQuery(context, query);
        PlacesSearchResponse response = request.await(); // Waits for the response

        // Returns the search results from the response
        return response.results;
    }
}
