package com.piiv.piiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piiv.piiv.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}