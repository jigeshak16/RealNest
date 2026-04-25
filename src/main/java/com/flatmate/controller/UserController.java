package com.flatmate.controller;

import com.flatmate.entity.User;
import com.flatmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // LOGIN API
    @PostMapping("/{role}/login")
    public String login(
            @PathVariable String role,
            @RequestBody Map<String, String> request
    ) {
        return userService.login(
                request.get("email"),
                request.get("password"),
                role
        );
    }

    // SIGNUP API
    @PostMapping("/{role}/signup")
    public String signup(
            @PathVariable String role,
            @RequestBody User user
    ) {
        if (role.equalsIgnoreCase("owner")) {
            user.setUserType(User.UserType.OWNER);
        } else {
            user.setUserType(User.UserType.SEEKER);
        }

        return userService.register(user);
    }

    // FORGOT PASSWORD API
    @PostMapping("/auth/forgot-password")
    public String forgotPassword(
            @RequestBody Map<String, String> request
    ) {
        return userService.sendResetLink(
                request.get("email")
        );
    }

    // RESET PASSWORD API
    @PostMapping("/auth/reset-password")
    public String resetPassword(
            @RequestBody Map<String, String> request
    ) {
        return userService.resetPassword(
                request.get("email"),
                request.get("password")
        );
    }

    // GET ALL USERS
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ NEW API (USERS + PREFERENCES)
    @GetMapping("/users-with-preferences")
    public List<Map<String, Object>> getUsersWithPreferences() {
        return userService.getUsersWithPreferences();
    }
}