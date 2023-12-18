package org.launchcode.parksfortails.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int searchId;
    private static int nextId = 1;
    private String city;
    private String state;

    private int zipCode;

    public Search() {
    }

    public Search(String city, String state, int zipCode) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.searchId = nextId;
        nextId++;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getSearchId() {
        return searchId;
    }
}
