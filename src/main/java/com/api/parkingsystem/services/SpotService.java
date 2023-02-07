package com.api.parkingsystem.services;

import com.api.parkingsystem.Dto.SpotDto;
import com.api.parkingsystem.models.CarModel;
import com.api.parkingsystem.models.SpotModel;
import com.api.parkingsystem.repositories.CarRepository;
import com.api.parkingsystem.repositories.SpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpotService {
    @Autowired
    SpotRepository spotRepository;

    @Autowired
    CarRepository carRepository;

    @Transactional
    public SpotModel save(SpotModel spotModel) {

        return spotRepository.save(spotModel);
    }

    @Transactional
    public SpotDto insert(SpotDto dto) {

        try {

            SpotModel spotModel = new SpotModel();
            CarModel carModel = new CarModel();

            spotModel.setId(null);
            carModel.setId(null);

            copyDtoToEntity(dto, spotModel, carModel);
            spotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

            spotModel = spotRepository.save(spotModel);

            return new SpotDto(spotModel);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error" + e.getMessage());
        }
    }

    public List<SpotModel> findAll() {
        return spotRepository.findAll();
    }
    public Page<SpotDto> findAllPaged(Pageable pageable) {
        Page<SpotModel> page = spotRepository.findAll(pageable);
        return page.map(x -> new SpotDto(x));
    }

    public SpotModel findById(UUID id) {
        Optional<SpotModel> obj = spotRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("Error"));
    }

    public void deleteById(UUID id) {
        try {
            spotRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error");
        }
    }

    public SpotDto updateSpot(SpotDto spotDto, UUID id) {
        Optional<SpotModel> obj = spotRepository.findById(id);
        SpotModel spot = obj.orElseThrow(() -> new IllegalArgumentException("Error"));
        CarModel car = spot.getCarModel();
        copyDtoToEntity(spotDto, spot, car);
        spot = spotRepository.save(spot);
        return new SpotDto(spot);
    }

    private void copyDtoToEntity(SpotDto dto, SpotModel spotModel, CarModel carModel) {
        spotModel.setBlock(dto.getBlock());
        spotModel.setSpotNumber(dto.getSpotNumber());
        spotModel.setApartment(dto.getApartment());
        spotModel.setResponsibleName(dto.getResponsibleName());
        carModel.setBrandCar(dto.getBrandCar());
        carModel.setModelCar(dto.getModelCar());
        carModel.setLicensePlate(dto.getLicensePlate());
        carModel.setColor(dto.getColor());

        spotModel.setCarModel(carModel);
        carModel.setSpot(spotModel);
    }
}
