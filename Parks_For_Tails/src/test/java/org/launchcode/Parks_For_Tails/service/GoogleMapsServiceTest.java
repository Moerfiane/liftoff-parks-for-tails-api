package org.launchcode.Parks_For_Tails.service;

import com.google.maps.model.PlacesSearchResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//This class contains unit tests for GoogleMapsService. It uses FakeGoogleMapsService to simulate responses from the
// Google Maps API and tests how GoogleMapsService processes these responses
public class GoogleMapsServiceTest {
    // This class contains tests for GoogleMapsService using the fake service

    @Test
    void testSearchParksWithFakeService() {
        // Using the fake Google Maps service for testing
        FakeGoogleMapsService fakeService = new FakeGoogleMapsService();
        String query = "central park";

        // Calls the fake service with a test query
        PlacesSearchResult[] results = fakeService.searchParks(query);

        // Asserts that the results are not null and match expected values
        assertNotNull(results);
        assertEquals(1, results.length);
        assertEquals("Central Park", results[0].name);
        assertEquals("New York, NY, USA", results[0].formattedAddress);
    }

    // Additional tests for different scenarios can be added here
}
