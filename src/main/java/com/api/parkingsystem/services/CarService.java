package com.api.parkingsystem.services;

import com.api.parkingsystem.models.CarModel;
import com.api.parkingsystem.models.SpotModel;
import com.api.parkingsystem.repositories.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Transactional
    public CarModel save(CarModel carModel){
        return carRepository.save(carModel);
    }

    /*public List<CarModel> findAll() {
        return carRepository.findAll();
    }*/
}
