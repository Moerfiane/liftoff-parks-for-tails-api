package com.launchcode.parksfortails.controllers.api;

import com.launchcode.parksfortails.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) //edit
@RestController
//@RequestMapping("/fill in here")
public class ApiController {

    @Autowired
    private UserRepository userRepository;

}