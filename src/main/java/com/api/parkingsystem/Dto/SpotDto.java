package com.api.parkingsystem.Dto;

import com.api.parkingsystem.models.SpotModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class SpotDto {

    private UUID id;
    private LocalDateTime registrationDate;
    @NotBlank
    private String spotNumber;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;
    @NotBlank
    @Size(max = 7)
    private String licensePlate;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String color;

    public SpotDto() {

    }

    public SpotDto(UUID id, LocalDateTime registrationDate, String spotNumber,
                   String responsibleName, String apartment, String block,
                   String licensePlate, String brandCar, String modelCar, String color) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.spotNumber = spotNumber;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
        this.licensePlate = licensePlate;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.color = color;
    }

    public SpotDto(SpotModel entity) {
        id = entity.getId();
        registrationDate = entity.getRegistrationDate();
        spotNumber = entity.getSpotNumber();
        responsibleName = entity.getResponsibleName();
        apartment = entity.getApartment();
        block = entity.getBlock();
        licensePlate = entity.getCarModel().getLicensePlate();
        brandCar = entity.getCarModel().getBrandCar();
        modelCar = entity.getCarModel().getModelCar();
        color = entity.getCarModel().getColor();
    }

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {

        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
