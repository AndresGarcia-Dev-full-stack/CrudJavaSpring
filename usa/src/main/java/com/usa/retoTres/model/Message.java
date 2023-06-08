package com.usa.retoTres.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMessage;
    private String messageText;

    //car
    @ManyToOne
    @JoinColumn(name="idcar")
    @JsonIgnoreProperties({"messages","reservations"})
    private Car car;

    //cliente
    @ManyToOne
    @JoinColumn(name="idclient")
    @JsonIgnoreProperties({"messages","reservas"})
    private Client client;
}
