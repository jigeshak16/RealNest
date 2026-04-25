package com.flatmate.controller;

import com.flatmate.entity.UserPreference;
import com.flatmate.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
@CrossOrigin(origins = "*")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService userPreferenceService;

    // ✅ SAVE OR UPDATE PREFERENCES
    @PostMapping("/save")
    public String savePreference(@RequestBody UserPreference pref) {
        return userPreferenceService.savePreference(pref);
    }

    // ✅ GET USER PREFERENCE (useful for edit/debug)
    @GetMapping("/{userId}")
    public UserPreference getPreference(@PathVariable Long userId) {
        return userPreferenceService.getPreferenceByUserId(userId);
    }
}