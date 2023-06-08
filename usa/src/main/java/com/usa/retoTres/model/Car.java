package com.usa.retoTres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idCar;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    //GAMA
    @ManyToOne
    @JoinColumn(name="idgama")
    @JsonIgnoreProperties("cars")
    private Gama gama;

    //MENSAJES
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Message> message;

    //RESERVAS
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Reservation> reservations;


}

