package com.launchcode.parksfortails.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;

// This class represents a user in the system.
@Entity
public class User {

    // Unique identifier for each user.
    @Id
    @GeneratedValue
    private Long id;

    // Username of the user, must be between 5 and 20 characters.
    @NotNull
    @Size(min = 5, max = 20, message = "Username must be between 5 & 20 characters.")
    private String username;

    // Email address of the user, must be a valid email.
    @Email(message = "Must be a valid email.")
    private String email;

    // Encrypted password hash of the user.
    @NotNull
    private String pwhash;

    // List of comments made by the user.
    // This establishes a one-to-many relationship with ParkComment entities.
    // The mappedBy attribute indicates the inverse side of the relationship (user field in ParkComment).
    // CascadeType.ALL ensures that any changes to a User entity cascade to its associated comments.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ParkComment> comments;

    // Default constructor required by JPA.
    public User() {}

    /**
     * Constructor for creating a new user with a username and password.
     *
     * @param username The username for the new user.
     * @param password The password for the new user.
     */
    public User(String username, String password) {
        this.username = username;
        this.pwhash = encoder.encode(password);
    }

    // Encoder instance for encrypting and verifying passwords.
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Check if the given password matches the stored encrypted password.
     *
     * @param password The password to check.
     * @return True if the password matches, false otherwise.
     */
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwhash);
    }

    /**
     * Get the unique identifier of the user.
     *
     * @return The user's unique identifier.
     */
    public Long getId() {
        return  id;
    }

    /**
     * Get the username of the user.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the email address of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the user.
     *
     * @param email The new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the username of the user.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the list of comments made by the user.
     *
     * @return The list of comments associated with the user.
     */
    public List<ParkComment> getComments() {
        return comments;
    }

    /**
     * Override the equals method to compare users based on id, username, and email.
     *
     * @param o The object to compare.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(email, user.email);
    }

    /**
     * Override the hashCode method to generate a hash based on id, username, and email.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, email);
    }
}
