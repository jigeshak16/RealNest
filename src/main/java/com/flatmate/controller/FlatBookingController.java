package com.flatmate.controller;

import com.flatmate.entity.FlatBooking;
import com.flatmate.service.FlatBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class FlatBookingController {

    @Autowired
    private FlatBookingService service;

    @PostMapping("/book")
    public String bookFlat(
            @RequestBody FlatBooking booking
    ) {
        return service.bookFlat(booking);
    }

    @GetMapping("/status/{flatId}")
    public boolean getStatus(
            @PathVariable Long flatId
    ) {
        return service.isBooked(flatId);
    }
}