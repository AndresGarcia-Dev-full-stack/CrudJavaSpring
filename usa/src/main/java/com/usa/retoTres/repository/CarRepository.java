package com.usa.retoTres.repository;

import com.usa.retoTres.model.Car;
import com.usa.retoTres.repository.crud.CardCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    @Autowired
    private CardCrudRepository cardCrudRepository;

    public List<Car> findAll(){
        return (List<Car>) cardCrudRepository.findAll();

    }
    public Optional<Car> getCar(int id){
        return cardCrudRepository.findById(id);

    }

    public Car save(Car car){
        return cardCrudRepository.save(car);
    }

    public void delete(Car car){
        cardCrudRepository.delete(car);
    }

}
