package com.bookingManagment.repository;

import com.bookingManagment.data.Building;
import com.bookingManagment.data.Workstation;
import com.bookingManagment.data.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
    List<WorkstationRepository> findByWorkstationTypeAndBuilding (WorkstationType type, Building building);
}
