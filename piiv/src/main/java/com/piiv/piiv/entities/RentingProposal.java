package com.piiv.piiv.entities;

import jakarta.persistence.*;

@Entity
public class RentingProposal {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "car_id", nullable = false)
    private Integer carId;

    // Additional attributes for the renting proposal

    // Constructors, getters, setters, etc.

    public RentingProposal() {
    }

    public RentingProposal(Integer userId, Integer carId) {
        this.userId = userId;
        this.carId = carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    // Additional getters and setters for other attributes
}