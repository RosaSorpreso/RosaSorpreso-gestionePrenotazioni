package com.bookingManagment.runner;


import com.bookingManagment.data.*;
import com.bookingManagment.repository.BookingRepository;
import com.bookingManagment.repository.BuildingRepository;
import com.bookingManagment.repository.UserRepository;
import com.bookingManagment.repository.WorkstationRepository;
import com.bookingManagment.reservationService.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;
    private final WorkstationRepository workstationRepository;
    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    @Autowired
    public Runner(BuildingRepository buildingRepository, UserRepository userRepository, WorkstationRepository workstationRepository, BookingRepository bookingRepository, BookingService bookingService) {
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
        this.workstationRepository = workstationRepository;
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            Building building0 = Building.builder()
                    .withName("Office")
                    .withAddress("Via Roma 10")
                    .withCity("Roma")
                    .build();

            Building building1 = Building.builder()
                    .withName("Office2")
                    .withAddress("Via Aldo Moro 145")
                    .withCity("Napoli")
                    .build();

            Building building2 = Building.builder()
                    .withName("Office3")
                    .withAddress("Via dei Pomodori 123")
                    .withCity("Genova")
                    .build();

            User user0 = User.builder()
                    .withId(1L)
                    .withFullName("Diego Sorpreso")
                    .withEmail("diego@sorpreso.com")
                    .withUserName("diego_cane")
                    .build();
            User user1 = User.builder()
                    .withId(2L)
                    .withFullName("Rosa Sorpreso")
                    .withEmail("rosa@sorpreso.com")
                    .withUserName("rosa01")
                    .build();
            User user2 = User.builder()
                    .withId(3L)
                    .withFullName("Giovanni Muciaccia")
                    .withEmail("giovanni@muciaccia.com")
                    .withUserName("art_attack")
                    .build();

            Workstation workstation0 = Workstation.builder()
                    .withId(1L)
                    .withBuilding(building0)
                    .withDescription("Sala privata")
                    .withMaxUser(4)
                    .withWorkstationType(WorkstationType.PRIVATE)
                    .build();

            Workstation workstation1 = Workstation.builder()
                    .withId(2L)
                    .withBuilding(building0)
                    .withDescription("Sala open space")
                    .withMaxUser(9)
                    .withWorkstationType(WorkstationType.OPEN_SPACE)
                    .build();

            Workstation workstation2 = Workstation.builder()
                    .withId(3L)
                    .withBuilding(building0)
                    .withDescription("meeting room")
                    .withMaxUser(2)
                    .withWorkstationType(WorkstationType.MEETING_ROOM)
                    .build();

            buildingRepository.save(building0);
            buildingRepository.save(building1);
            buildingRepository.save(building2);
            userRepository.save(user0);
            userRepository.save(user1);
            userRepository.save(user2);
            workstationRepository.save(workstation0);
            workstationRepository.save(workstation1);
            workstationRepository.save(workstation2);

            System.out.println("buildings successfully saved");
            System.out.println("users successfully saved");
            System.out.println("workstations successfully saved");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
