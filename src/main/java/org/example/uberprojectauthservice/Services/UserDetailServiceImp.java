package org.example.uberprojectauthservice.Services;

import org.example.uberprojectauthservice.Helper.AuthPassengerDetails;
import org.example.uberprojectauthservice.Models.Passenger;
import org.example.uberprojectauthservice.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * this class is responsible for loading the user in the form of userDetail object for auth.
 *
 *
 */
@Primary
@Service
public class UserDetailServiceImp implements UserDetailsService {
@Autowired
    private  PassengerRepository passengerRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
   Optional<Passenger> passenger = passengerRepository.findByEmail(email);
   if(passenger.isPresent()){
       return new AuthPassengerDetails(passenger.get());
   }

   else {
       throw new UsernameNotFoundException("User not found");
   }
    }
}

