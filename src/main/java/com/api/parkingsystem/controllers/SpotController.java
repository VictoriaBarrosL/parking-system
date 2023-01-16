package com.api.parkingsystem.controllers;


import com.api.parkingsystem.Dto.SpotDto;
import com.api.parkingsystem.models.SpotModel;
import com.api.parkingsystem.services.SpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/spoties")
public class SpotController {

    @Autowired
    SpotService spotService;

    @PostMapping
    public ResponseEntity<Object> saveSpot(@RequestBody @Valid SpotDto spotDto) {
        var spot = new SpotModel();
        BeanUtils.copyProperties(spotDto, spot);
        spot.setregistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(spotService.save(spot));
    }

    @GetMapping
    public ResponseEntity<List<SpotModel>> getAllSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(spotService.findAll());

    }
}
