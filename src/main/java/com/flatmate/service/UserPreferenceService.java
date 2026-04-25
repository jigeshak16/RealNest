package com.flatmate.service;

import com.flatmate.entity.UserPreference;
import com.flatmate.repository.UserPreferenceRepository;
import com.flatmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPreferenceService {

    @Autowired
    private UserPreferenceRepository repository;

    @Autowired
    private UserRepository userRepository;

    // ✅ SAVE OR UPDATE PROFILE (MERGED & FIXED)
    public String savePreference(UserPreference preference) {

        Optional<UserPreference> existing =
                repository.findByUserId(preference.getUserId());

        if (existing.isPresent()) {

            UserPreference old = existing.get();

            old.setFoodType(preference.getFoodType());
            old.setSmoking(preference.getSmoking());
            old.setDrinking(preference.getDrinking());
            old.setSleepSchedule(preference.getSleepSchedule());
            old.setCleanlinessLevel(preference.getCleanlinessLevel());

            old.setMinBudget(preference.getMinBudget());
            old.setMaxBudget(preference.getMaxBudget());

            // 👉 add more fields if you have
            // old.setGuestsAllowed(...)
            // old.setWorkType(...)
            // old.setPetsAllowed(...)

            repository.save(old);

            return "Preferences updated successfully";

        } else {

            repository.save(preference);

            return "Preferences saved successfully";
        }
    }

    // ✅ OPTIONAL: GET PREFERENCE (used for edit/debug)
    public UserPreference getPreferenceByUserId(Long userId) {
        return repository.findByUserId(userId).orElse(null);
    }
}