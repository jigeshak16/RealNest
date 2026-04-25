package com.flatmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    public enum UserType {
        OWNER,
        SEEKER
    }

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String phone;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String location;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    // Getters & Setters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public String getProfilePicture() { return profilePicture; }
    public UserType getUserType() { return userType; }
    public Gender getGender() { return gender; }
    public Integer getAge() { return age; }
    public String getBio() { return bio; }
    public String getLocation() { return location; }
    public Boolean getIsActive() { return isActive; }

    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
    public void setUserType(UserType userType) { this.userType = userType; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setAge(Integer age) { this.age = age; }
    public void setBio(String bio) { this.bio = bio; }
    public void setLocation(String location) { this.location = location; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}