package com.bookingManagment.repository;

import com.bookingManagment.data.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
