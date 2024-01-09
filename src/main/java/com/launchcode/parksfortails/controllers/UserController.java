package com.launchcode.parksfortails.controllers;

import com.launchcode.parksfortails.data.UserRepository;
import com.launchcode.parksfortails.models.User;
import com.launchcode.parksfortails.models.dto.RegistrationFormDTO;
import com.launchcode.parksfortails.models.dto.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;
import org.springframework.validation.Errors;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Key for storing the user ID in the session
    private static final String userSessionKey = "user";

    // Method to store user session
    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    // Method to retrieve user from session if it exists
    public User getUserFromSession(HttpSession session) {
        // Retrieve the user ID from the session
        Long userId = (Long) session.getAttribute(userSessionKey);

        // Check if the session contains a user ID
        if (userId == null) {
            return null;
        }

        // Attempt to find the user in the database by ID
        Optional<User> userOpt = userRepository.findById(userId);

        // Check if the user with the given ID exists
        if (userOpt.isEmpty()) {
            return null;
        }

        // Return the user if found
        return userOpt.get();
    }

    // Endpoint to display the registration form
    @GetMapping("/register")
    public String displayRegistrationForm(Model model, HttpSession session) {
        // Add an empty RegistrationFormDTO to the model for form binding
        model.addAttribute(new RegistrationFormDTO());

        // Add a flag indicating whether a user is logged in to the model
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        // Return the name of the registration view template
        return "register";
    }

    // Endpoint to process the registration form submission
    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Validated RegistrationFormDTO registrationFormDTO,
                                          Errors errors,
                                          HttpServletRequest request) {
        // Check for validation errors in the form
        if (errors.hasErrors()) {
            return "register";  // If errors, return to the registration form
        }

        // Check if a user with the same username already exists
        User existingUser = userRepository.findByUsername(registrationFormDTO.getUsername());
        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyExists", "That username already exists");
            return "register";  // If username exists, return to the registration form
        }

        // Check if password and verify password fields match
        String password = registrationFormDTO.getPassword();
        String verifyPassword = registrationFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            return "register";  // If passwords don't match, return to the registration form
        }

        // Create a new user with the provided username and password
        User newUser = new User(registrationFormDTO.getUsername(), registrationFormDTO.getPassword());

        // Save the new user to the database
        userRepository.save(newUser);

        // Log in the new user by storing their ID in the session
        setUserInSession(request.getSession(), newUser);

        // Redirect to the search page
        return "redirect:/search";
    }

    // Endpoint to display the login form
    @GetMapping("/login")
    public String displayLoginForm(Model model, HttpSession session) {
        // Add an empty LoginFormDTO to the model for form binding
        model.addAttribute(new LoginFormDTO());

        // Add a flag indicating whether a user is logged in to the model
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        // Return the name of the login view template
        return "login";
    }

    // Endpoint to process the login form submission
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Validated LoginFormDTO loginFormDTO,
                                   Errors errors,
                                   HttpServletRequest request) {
        // Check for validation errors in the form
        if (errors.hasErrors()) {
            return "login";  // If errors, return to the login form
        }

        // Find the user in the database by username
        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        // Get the password from the form
        String password = loginFormDTO.getPassword();

        // Verify if the username exists and the password (hashed) matches
        if (theUser == null || !theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "login.invalid", "Invalid login. Please try again.");
            return "login";  // If incorrect, return to the login form
        }

        // If correct, log in the user by storing their ID in the session
        setUserInSession(request.getSession(), theUser);

        // Redirect to the search page
        return "redirect:/search";
    }

    //logout page
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";

    }
}