package com.flatmate.repository;

import com.flatmate.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreferenceRepository extends JpaRepository<UserPreference, Long> {

    Optional<UserPreference> findByUserId(Long userId);
}