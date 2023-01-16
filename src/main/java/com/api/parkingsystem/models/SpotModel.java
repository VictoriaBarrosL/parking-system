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

    @OneToOne(cascade = CascadeType.ALL)
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

    public void setregistrationDate(LocalDateTime utc) {
    }
}
