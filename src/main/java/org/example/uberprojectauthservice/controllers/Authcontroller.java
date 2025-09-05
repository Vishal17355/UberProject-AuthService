package org.example.uberprojectauthservice.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.uberprojectauthservice.Models.Passenger;
import org.example.uberprojectauthservice.Services.AuthService;
import org.example.uberprojectauthservice.Services.JwtService;
import org.example.uberprojectauthservice.dto.AuthRequestDto;
import org.example.uberprojectauthservice.dto.AuthResponseDTo;
import org.example.uberprojectauthservice.dto.PassengerDto;
import org.example.uberprojectauthservice.dto.PassengerSignUpRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class Authcontroller {
    @Value("${cookie.expiry}")
    private int cookieExpiry;
private AuthService authService;

private final JwtService jwtService;


private final AuthenticationManager authenticationManager;


public Authcontroller(AuthService authService, AuthenticationManager authenticationManager , JwtService jwtService) {
    this.authService=authService;
    this.authenticationManager=authenticationManager;
    this.jwtService=jwtService;
}

    @PostMapping("/signUp/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequestDto passengerSignUpRequestDto){

      PassengerDto response =   authService.signupPassenger(passengerSignUpRequestDto);


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/signin/passenger")
    public ResponseEntity<?> signIp(@RequestBody AuthRequestDto authRequestDto , HttpServletResponse response){
Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));
if(authentication.isAuthenticated()){

    response.setHeader(HttpHeaders.SET_COOKIE  , "12345");
    Map<String , Object> payload = new HashMap<>();
    payload.put("email" , authRequestDto.getEmail());


    String jwtToken = jwtService.createToken(authRequestDto.getEmail());


    String JwtToken = "";
    ResponseCookie cookie =ResponseCookie.from("JwtToken" , JwtToken)
            .httpOnly(true)
            .secure(false)
            .path("/")
            .maxAge(cookieExpiry)
            .build();

    response.setHeader(HttpHeaders.SET_COOKIE , cookie.toString());
    return new  ResponseEntity<>(jwtToken, HttpStatus.OK);

}

        return new ResponseEntity<>(AuthResponseDTo.builder().success(true).build(), HttpStatus.OK);
    }


}
