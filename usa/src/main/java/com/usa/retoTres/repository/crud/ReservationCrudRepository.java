package com.usa.retoTres.repository.crud;

import com.usa.retoTres.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
