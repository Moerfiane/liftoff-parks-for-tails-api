package org.launchcode.parksfortails.controllers;

import org.launchcode.parksfortails.data.UserRepository;
import org.launchcode.parksfortails.models.User;
import org.launchcode.parksfortails.models.dto.RegistrationFormDTO;
import org.launchcode.parksfortails.models.dto.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;
import org.springframework.validation.Errors;
import jakarta.validation.Valid;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";  // user ID key

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
        System.out.println("session: " + session.getAttribute("user"));
    }


    //get user if not null or empty
    public User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isEmpty()) {
            return null;
        }

        return userOpt.get();
    }

    //registration form

    @GetMapping("/register")
    public String displayRegistrationForm(Model model, HttpSession session) {
        model.addAttribute(new RegistrationFormDTO());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegistrationFormDTO registrationFormDTO,
                                          Errors errors,
                                          HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "register";
        }


        User existingUser = userRepository.findByUsername(registrationFormDTO.getUsername()); //need to add registration DTO


        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyExists", "That username is already in use");
            return "register";
        }
    return "register";
    }

//        String password = registrationFormDTO.getPassword(); //need to add registration DTO
//        String verifyPassword = registrationFormDTO.getVerifyPassword(); //need VP
//        if (!password.equals(verifyPassword)) {
//            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
//            return "register";
//        }

//        User newUser = new User(registrationFormDTO.getUsername(), registrationFormDTO.getPassword());
//        userRepository.save(newUser);
//        setUserInSession(request.getSession(), newUser);
//        return "redirect:/artworks";
//    }


//  @GetMapping("/login")
//    public String displayLoginForm(Model model, HttpSession session) {
//        model.addAttribute(new LoginFormDTO()); // "loginFormDTO" variable implicit
//        model.addAttribute("loggedIn", session.getAttribute("user") != null);
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
//                                   Errors errors,
//                                   HttpServletRequest request) {
//
//       if (errors.hasErrors()) {
//            return "login";
//        }
//
//
//        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());
//
//
//        String password = loginFormDTO.getPassword();
//
//
//        if (theUser == null || !theUser.isMatchingPassword(password)) {
//            errors.rejectValue(
//                    "password",
//                    "login.invalid",
//                    "Invalid login. Please try again with the correct username/password combination."
//            );
//            return "login";
//        }
//
//
//        setUserInSession(request.getSession(), theUser);
//        return "redirect:/"; //needs main url
//    }
//
//        @GetMapping("/logout")
//    public String logout(HttpServletRequest request){
//        request.getSession().invalidate();
//        return "redirect:/login";
//
//}
    }