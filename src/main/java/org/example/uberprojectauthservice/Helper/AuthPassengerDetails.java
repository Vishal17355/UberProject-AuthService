package org.example.uberprojectauthservice.Helper;

import org.example.uberprojectauthservice.Models.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


// why we need this class?
// because spring security works on userdetails polymorphic type for auth
public class AuthPassengerDetails extends Passenger implements UserDetails {

    private String username;
    private String password;

    public  AuthPassengerDetails(Passenger passenger) {
        this.username = passenger.getEmail();
        this.password = passenger.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
