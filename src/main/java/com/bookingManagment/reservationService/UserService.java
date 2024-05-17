package com.bookingManagment.reservationService;

import com.bookingManagment.data.User;
import com.bookingManagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
}
