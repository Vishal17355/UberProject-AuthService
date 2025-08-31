package org.example.uberprojectauthservice.controllers;

import org.example.uberprojectauthservice.Models.Passenger;
import org.example.uberprojectauthservice.Services.AuthService;
import org.example.uberprojectauthservice.dto.PassengerDto;
import org.example.uberprojectauthservice.dto.PassengerSignUpRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class Authcontroller {
private AuthService authService;
public Authcontroller(AuthService authService){
    this.authService=authService;
}

    @PostMapping("/signUp/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequestDto passengerSignUpRequestDto){

      PassengerDto response =   authService.signupPassenger(passengerSignUpRequestDto);


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/signin/passenger")
    public ResponseEntity<?> signIp(){



        return new ResponseEntity<>(10, HttpStatus.CREATED);
    }

}
