package org.launchcode.parksfortails.models;

import jakarta.persistence.*;

@Entity
@Table(name = "park")
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Other attributes related to the Park entity

    // Constructors, getters, and setters

    public Park() {
        // Default constructor
    }


    public Park(String name) {
        this.name = name;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
