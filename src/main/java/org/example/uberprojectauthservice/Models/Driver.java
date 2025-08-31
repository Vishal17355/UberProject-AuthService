package org.example.uberprojectauthservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "bookings")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Driver extends BaseModel {
    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;


    private String phoneNumber;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Booking> bookings = new HashSet<>();
}
