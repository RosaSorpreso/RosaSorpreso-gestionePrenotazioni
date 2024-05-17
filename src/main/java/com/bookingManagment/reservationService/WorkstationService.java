package com.bookingManagment.reservationService;

import com.bookingManagment.data.Building;
import com.bookingManagment.data.Workstation;
import com.bookingManagment.data.WorkstationType;
import com.bookingManagment.repository.BuildingRepository;
import com.bookingManagment.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WorkstationService {
    @Autowired
    private WorkstationRepository workstationRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    public Workstation findById(Long id){
        Optional<Workstation> workstationOptional = workstationRepository.findById(id);
        return workstationOptional.orElse(null);
    }

    public List<Workstation> findByTypeOfWorkstationAndBuilding (WorkstationType type, String city){
        Building building = buildingRepository.findByCity(city);

        if(building != null){
            return workstationRepository.findByWorkstationTypeAndBuilding(type, building);
        } else {
            return Collections.emptyList();
        }
    }
}
