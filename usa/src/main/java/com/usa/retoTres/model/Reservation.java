package com.usa.retoTres.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    //car
    @ManyToOne
    @JoinColumn(name = "idcar")
    @JsonIgnoreProperties("reservations")
    private  Car car ;


    //client

    @ManyToOne
    @JoinColumn(name = "idclient")
    @JsonIgnoreProperties({"reservations","messages"})
    private  Client client ;


    //score
    @OneToOne
    @JsonIgnoreProperties("resrvation")
    private Score score;
}
