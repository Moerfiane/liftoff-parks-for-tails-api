package org.launchcode.parksfortails.controllers;

import org.launchcode.parksfortails.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

}