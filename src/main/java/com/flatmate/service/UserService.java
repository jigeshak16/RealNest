package com.flatmate.service;

import com.flatmate.entity.User;
import com.flatmate.entity.UserPreference;
import com.flatmate.repository.UserRepository;
import com.flatmate.repository.PreferenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PreferenceRepository preferenceRepository;   // ✅ NEW

    @Autowired
    private JavaMailSender mailSender;

    // REGISTER
    public String register(User user) {
        userRepository.save(user);
        return "Registration Success";
    }

    // LOGIN
    public String login(String email, String password, String role) {

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            String expectedRole = role.equalsIgnoreCase("owner")
                    ? "OWNER"
                    : "SEEKER";

            if (user.getPassword().equals(password) &&
                    user.getUserType().name().equalsIgnoreCase(expectedRole)) {
                return "Login Success|" + user.getId();
            }
        }

        return "Invalid email or password";
    }

    // FORGOT PASSWORD
    public String sendResetLink(String email) {

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            return "Email not found";
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Reset Password - Realnest");
        message.setText(
                "Hello,\n\n" +
                        "Click the link below to reset your password:\n" +
                        "http://192.168.134.7:8080/reset-password\n\n" +
                        "Regards,\nRealnest Team"
        );

        mailSender.send(message);

        return "Password reset link sent successfully";
    }

    // RESET PASSWORD
    public String resetPassword(String email, String password) {

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPassword(password);
            userRepository.save(user);

            return "Password updated successfully";
        }

        return "Email not found";
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ NEW METHOD (USERS + PREFERENCES COMBINED)
    public List<Map<String, Object>> getUsersWithPreferences() {

        List<User> users = userRepository.findAll();
        List<Map<String, Object>> result = new ArrayList<>();

        for (User user : users) {

            Optional<UserPreference> prefOpt =
                    preferenceRepository.findByUserId(user.getId());

            // ❗ IMPORTANT: Only include users WITH preferences
            if (prefOpt.isEmpty()) continue;

            UserPreference pref = prefOpt.get();

            Map<String, Object> map = new HashMap<>();

            map.put("id", user.getId());
            map.put("fullName", user.getFullName());

            map.put("foodType", pref.getFoodType());
            map.put("smoking", pref.getSmoking());
            map.put("drinking", pref.getDrinking());
            map.put("sleepSchedule", pref.getSleepSchedule());
            map.put("cleanlinessLevel", pref.getCleanlinessLevel());
            map.put("maxBudget", pref.getMaxBudget());

            result.add(map);
        }

        return result;
    }
}