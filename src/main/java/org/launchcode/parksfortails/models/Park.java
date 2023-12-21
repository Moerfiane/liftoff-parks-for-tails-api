package org.launchcode.parksfortails.models;

<<<<<<<<< Temporary merge branch 1
// Park.java
import javax.persistence.*;
import java.util.List;

@Entity
public class Park {

=========
import jakarta.persistence.*;

@Entity
@Table(name = "park")
public class Park {
>>>>>>>>> Temporary merge branch 2
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<<<< Temporary merge branch 1
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    // Assume a OneToMany relationship with ParkComment entity
    @OneToMany(mappedBy = "park", cascade = CascadeType.ALL)
    private List<ParkComment> comments;

    // Constructors, getters, setters

    // Additional functionality and comments:

    // This class represents the Park entity in the database.
    // It contains fields such as id, name, and location that correspond to the park's attributes.


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
