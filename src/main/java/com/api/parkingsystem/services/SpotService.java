package com.api.parkingsystem.services;

import com.api.parkingsystem.models.SpotModel;
import com.api.parkingsystem.repositories.CarRepository;
import com.api.parkingsystem.repositories.SpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotService {

    @Autowired
    SpotRepository spotRepository;

    @Autowired
    CarRepository carRepository;

    @Transactional
    public SpotModel save(SpotModel spotModel){
        return spotRepository.save(spotModel);
    }

    public List<SpotModel> findAll() {
        return spotRepository.findAll();
    }
}
