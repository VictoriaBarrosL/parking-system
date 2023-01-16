package com.api.parkingsystem.controllers;


import com.api.parkingsystem.Dto.SpotDto;
import com.api.parkingsystem.models.CarModel;
import com.api.parkingsystem.models.SpotModel;
import com.api.parkingsystem.repositories.SpotRepository;
import com.api.parkingsystem.services.CarService;
import com.api.parkingsystem.services.SpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    SpotService spotService;
    @Autowired
    private SpotRepository spotRepository;

    @PostMapping
    public ResponseEntity<Object> saveCar(@RequestBody @Valid SpotDto spotDto) {
        var car = new CarModel();
        BeanUtils.copyProperties(spotDto, car);
        Object obj = carService.save(car);
       return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CarModel>> getAllCars(){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAll());

    }
}
