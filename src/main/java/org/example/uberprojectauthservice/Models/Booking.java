package org.example.uberprojectauthservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.example.uberprojectauthservice.Models.BaseModel;
import org.example.uberprojectauthservice.Models.BookingStatus;
import org.example.uberprojectauthservice.Models.Driver;
import org.example.uberprojectauthservice.Models.Passenger;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseModel {




    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;

    private long totalDist;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;
}