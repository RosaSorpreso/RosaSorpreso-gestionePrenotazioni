package com.bookingManagment.reservationService;

import com.bookingManagment.data.Booking;
import com.bookingManagment.data.User;
import com.bookingManagment.data.Workstation;
import com.bookingManagment.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private WorkstationService workstationService;

    @Autowired
    private UserService userService;

    public BookingRepository createBooking(Long userId, Long workstationId, LocalDate bookingDate){
        User user = userService.findById(userId);
        Workstation workstation = workstationService.findById(workstationId);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setWorkstation(workstation);
        booking.setBookingDate(bookingDate);
        return (BookingRepository) bookingRepository.save(booking);
    }

    public boolean isUserAlreadyBooked(User user, LocalDate bookingDate){
        return bookingRepository.existsByUserAndBookingDate(user, bookingDate);
    }

    public boolean isWorkstationAvailable(Workstation workstation, LocalDate bookingDate){
        return !bookingRepository.existsByWorkstationAndBookingDate(workstation, bookingDate);
    }

    public List<Booking> bookingByUserAndDate(User user, LocalDate bookingDate){
        return bookingRepository.findByUserAndBookingDate(user, bookingDate);
    }

}
