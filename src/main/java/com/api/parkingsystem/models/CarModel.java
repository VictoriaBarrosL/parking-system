package com.api.parkingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_CAR")
public class CarModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlate;
    @Column(nullable = false, length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String brandCar;
    @Column(nullable = false, length = 70)
    private String color;

    @OneToOne
    @JsonIgnore
    private SpotModel spotModel;

    public CarModel() {
    }

    public CarModel(UUID id, String licensePlate, String modelCar, String brandCar, String color) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.modelCar = modelCar;
        this.brandCar = brandCar;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public SpotModel getSpot() {
        return spotModel;
    }

    public void setSpot(SpotModel spotModel) {
        this.spotModel = spotModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(id, carModel.id) && Objects.equals(licensePlate, carModel.licensePlate)
                && Objects.equals(modelCar, carModel.modelCar)
                && Objects.equals(brandCar, carModel.brandCar)
                && Objects.equals(color, carModel.color)
                && Objects.equals(spotModel, carModel.spotModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licensePlate, modelCar, brandCar, color, spotModel);
    }

}



