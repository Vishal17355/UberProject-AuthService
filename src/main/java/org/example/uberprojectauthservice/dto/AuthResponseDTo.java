package org.example.uberprojectauthservice.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDTo {
    boolean success;
    private String email;
    private String password;
}
