package com.bookingManagment.repository;

import com.bookingManagment.data.Building;
import com.bookingManagment.data.Workstation;
import com.bookingManagment.data.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
    List<Workstation> findByWorkstationTypeAndBuilding (WorkstationType type, Building building);
    Optional<Workstation> findById (Long id);
}
