package com.bookingManagment.repository;

import com.bookingManagment.data.Booking;
import com.bookingManagment.data.User;
import com.bookingManagment.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserAndDate (User user, LocalDate date);
    boolean existsByWorkstationAndDate (Workstation workstation, LocalDate date);
}
