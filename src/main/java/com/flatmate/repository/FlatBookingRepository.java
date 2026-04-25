package com.flatmate.repository;

import com.flatmate.entity.FlatBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlatBookingRepository
        extends JpaRepository<FlatBooking, Long> {

    Optional<FlatBooking> findByFlatId(Long flatId);
}
