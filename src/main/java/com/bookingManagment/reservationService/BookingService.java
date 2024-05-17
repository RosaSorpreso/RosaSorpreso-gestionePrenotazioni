package com.bookingManagment.reservationService;

import com.bookingManagment.data.Booking;
import com.bookingManagment.data.User;
import com.bookingManagment.data.Workstation;
import com.bookingManagment.repository.BookingRepository;
import com.bookingManagment.repository.UserRepository;
import com.bookingManagment.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private UserRepository userRepository;

    public BookingRepository createBooking(String username, Long workstationId, LocalDate date){
        User user = userRepository.findById(Integer.valueOf(username))
                .orElseThrow( () -> new RuntimeException("User not found"));
        Workstation workstation = workstationRepository.findById(Math.toIntExact(workstationId))
                .orElseThrow( () -> new RuntimeException("Workstation not found"));

        Booking booking = new Booking();

    }
}
