package com.bookingManagment.repository;

import com.bookingManagment.data.Booking;
import com.bookingManagment.data.User;
import com.bookingManagment.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserAndBookingDate (User user, LocalDate bookingDate);
    boolean existsByWorkstationAndBookingDate (Workstation workstation, LocalDate bookingDate);
    boolean existsByUserAndBookingDate (User user, LocalDate bookingDate);
}
