package org.example.uberprojectauthservice.controllers;

import org.example.uberprojectauthservice.dto.PassengerDto;
import org.example.uberprojectauthservice.dto.PassengerSignUpRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class Authcontroller {


    @PostMapping("/signUp/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequestDto passengerSignUpRequestDto){
        return null;
    }

}
