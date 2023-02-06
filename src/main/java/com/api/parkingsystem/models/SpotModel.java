package com.api.parkingsystem.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_SPOT")
public class SpotModel implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String spotNumber;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 70)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "spotModel")
    private CarModel carModel;

    public SpotModel(){

    }
    public SpotModel(UUID id, String spotNumber, LocalDateTime registrationDate, String responsibleName,
                     String apartment, String block, CarModel carModel) {
        this.id = id;
        this.spotNumber = spotNumber;
        this.registrationDate = registrationDate;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
        this.carModel = carModel;
    }

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public String getSpotNumber() {

        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {

        this.spotNumber = spotNumber;
    }

    public LocalDateTime getRegistrationDate() {

        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {

        this.registrationDate = registrationDate;
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

    public CarModel getCarModel() {

        return carModel;
    }

    public void setCarModel(CarModel carModel) {

        this.carModel = carModel;
    }
}
