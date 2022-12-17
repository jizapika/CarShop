package com.jizapika.carShop.repos;

import com.jizapika.carShop.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo extends CrudRepository<Car, Long> {
    List<Car> findByColor(String color);
}
