package com.flatmate.service;

import com.flatmate.entity.FlatBooking;
import com.flatmate.repository.FlatBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatBookingService {

    @Autowired
    private FlatBookingRepository repository;

    public String bookFlat(FlatBooking booking) {

        if (repository.findByFlatId(booking.getFlatId()).isPresent()) {
            return "Flat already booked";
        }

        repository.save(booking);
        return "Flat booked successfully";
    }

    public boolean isBooked(Long flatId) {
        return repository.findByFlatId(flatId).isPresent();
    }
}