package com.flatmate.repository;

import com.flatmate.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Long> {
}