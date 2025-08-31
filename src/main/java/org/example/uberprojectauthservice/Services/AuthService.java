package org.example.uberprojectauthservice.Services;

import org.example.uberprojectauthservice.Models.Passenger;
import org.example.uberprojectauthservice.dto.PassengerDto;
import org.example.uberprojectauthservice.dto.PassengerSignUpRequestDto;
import org.example.uberprojectauthservice.repositories.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final PassengerRepository passengerRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public AuthService(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto signupPassenger(PassengerSignUpRequestDto passengerSignUpRequestDto){
     Passenger passenger = Passenger.builder()
                     .email(passengerSignUpRequestDto.getEmail())
                             .name(passengerSignUpRequestDto.getName())
                                     .password(bCryptPasswordEncoder.encode( passengerSignUpRequestDto.getPassword()))   // TODO : Encrypt the password
                                             .phoneNumber(passengerSignUpRequestDto.getPhoneNumber())

             .build();

       Passenger newPassenger = passengerRepository.save(passenger);
    return   PassengerDto.from(newPassenger);
 }


}
