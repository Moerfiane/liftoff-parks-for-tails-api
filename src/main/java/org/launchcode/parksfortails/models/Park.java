package org.launchcode.parksfortails.models;

<<<<<<< HEAD
import jakarta.persistence.*;

@Entity
@Table(name = "park")
public class Park {
=======
// Park.java
import javax.persistence.*;
import java.util.List;

@Entity
public class Park {

>>>>>>> origin/main
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
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
=======
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

    // The @Entity annotation indicates that this class is a JPA entity and will be mapped to a database table.

    // The @Id and @GeneratedValue annotations specify that the 'id' field is the primary key and will be automatically
    // generated using the GenerationType.IDENTITY strategy.

    // The @Column annotation is used to customize the column mapping in the database.
    // In this case, 'name' and 'location' are non-nullable columns.

    // The @OneToMany annotation indicates a one-to-many relationship with the ParkComment entity.
    // It specifies that the 'comments' field represents a collection of ParkComment entities associated with this park.
    // The mappedBy attribute indicates the inverse side of the relationship (i.e., the 'park' field in ParkComment).

    // CascadeType.ALL is used to specify that any changes made to a Park entity should be cascaded to its associated comments.

    // Constructors, getters, and setters are standard methods for initializing, accessing, and modifying the fields of the entity.
>>>>>>> origin/main
}
