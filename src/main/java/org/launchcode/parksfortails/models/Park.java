package org.launchcode.parksfortails.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "park")
public class Park {
        private String name;
        private String location;
        private String description;
        private double latitude;
        private double longitude;
        private int establishedYear;
        private List<String> facilities; // e.g., "Picnic areas," "Playground," "Hiking trails"
        private boolean petFriendly;
        private String imageUrl;


        public Park() {
            // Default constructor
        }


        // Constructors, getters, setters

    public Park(String name, String location, String description, double latitude, double longitude, int establishedYear, List<String> facilities, boolean petFriendly, String imageUrl) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.establishedYear = establishedYear;
        this.facilities = facilities;
        this.petFriendly = petFriendly;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Park park)) return false;
        return Double.compare(getLatitude(), park.getLatitude()) == 0 && Double.compare(getLongitude(), park.getLongitude()) == 0 && getEstablishedYear() == park.getEstablishedYear() && isPetFriendly() == park.isPetFriendly() && Objects.equals(getName(), park.getName()) && Objects.equals(getLocation(), park.getLocation()) && Objects.equals(getDescription(), park.getDescription()) && Objects.equals(getFacilities(), park.getFacilities()) && Objects.equals(getImageUrl(), park.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation(), getDescription(), getLatitude(), getLongitude(), getEstablishedYear(), getFacilities(), isPetFriendly(), getImageUrl());
    }

    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", establishedYear=" + establishedYear +
                ", facilities=" + facilities +
                ", petFriendly=" + petFriendly +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}