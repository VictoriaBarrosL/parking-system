package com.api.parkingsystem.controllers;

import com.api.parkingsystem.Dto.SpotDto;
import com.api.parkingsystem.models.SpotModel;
import com.api.parkingsystem.services.SpotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/spoties")
public class SpotController {

    @Autowired
    SpotService spotService;

    @PostMapping
    public ResponseEntity<SpotDto> insert(@RequestBody @Valid SpotDto spotDto) {
        spotService.insert(spotDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(spotDto);
    }

    @GetMapping
    public ResponseEntity<List<SpotDto>> findAll() {
        List<SpotModel> list = spotService.findAll();
        List<SpotDto> listDto = list.stream().map(x -> new SpotDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/paged")
    public ResponseEntity<Page<SpotDto>> findAllPaged(Pageable pageable) {
        Page<SpotDto> page = spotService.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SpotDto> findById(@PathVariable UUID id) {
        SpotModel spotModel = spotService.findById(id);
        return ResponseEntity.ok().body(new SpotDto(spotModel));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        spotService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SpotDto> update(@RequestBody SpotDto spotDto, @PathVariable UUID id) {
        SpotDto dto = spotService.updateSpot(spotDto, id);
        return ResponseEntity.ok().body(dto);
    }
}
