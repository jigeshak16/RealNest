package com.flatmate.repository;

import com.flatmate.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPreferenceRepository
        extends JpaRepository<UserPreference, Long> {

    // FIND PROFILE BY USER ID
    Optional<UserPreference> findByUserId(Long userId);

    // FIND ALL OTHER USERS FOR MATCHING
    List<UserPreference> findAllByUserIdNot(Long userId);
}