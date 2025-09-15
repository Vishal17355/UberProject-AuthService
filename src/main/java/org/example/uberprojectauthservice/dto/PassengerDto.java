package org.example.uberprojectauthservice.dto;

import lombok.*;
import org.example.uberprojectentityservice.Models.Passenger;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {
    private long id;
    private String name;
    private String password;   // encrypted password
    private String email;
    private String phoneNumber;
    private Date createdAt;

    public static  PassengerDto from(Passenger p) {
        PassengerDto result = PassengerDto.builder()
                .id(p.getId())
                .createdAt(p.getCreatedAt())
                .email(p.getEmail())
                .password(p.getPassword())
                .phoneNumber(p.getPhoneNumber())
                .name(p.getName())
                .build();
        return result;
    }
}
