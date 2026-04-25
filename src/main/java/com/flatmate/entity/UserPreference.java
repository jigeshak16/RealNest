package com.flatmate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", unique = true)
    private Long userId;

    private Boolean smoking;

    private String drinking;

    @Column(name="food_type")
    private String foodType;

    @Column(name="sleep_schedule")
    private String sleepSchedule;

    @Column(name="cleanliness_level")
    private String cleanlinessLevel;

    @Column(name="min_budget")
    private Double minBudget;

    @Column(name="max_budget")
    private Double maxBudget;

    @Column(name="preferred_gender")
    private String preferredGender;

    @Column(name="preferred_age_min")
    private Integer preferredAgeMin;

    @Column(name="preferred_age_max")
    private Integer preferredAgeMax;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Boolean getSmoking() { return smoking; }
    public void setSmoking(Boolean smoking) { this.smoking = smoking; }

    public String getDrinking() { return drinking; }
    public void setDrinking(String drinking) { this.drinking = drinking; }

    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }

    public String getSleepSchedule() { return sleepSchedule; }
    public void setSleepSchedule(String sleepSchedule) { this.sleepSchedule = sleepSchedule; }

    public String getCleanlinessLevel() { return cleanlinessLevel; }
    public void setCleanlinessLevel(String cleanlinessLevel) { this.cleanlinessLevel = cleanlinessLevel; }

    public Double getMinBudget() { return minBudget; }
    public void setMinBudget(Double minBudget) { this.minBudget = minBudget; }

    public Double getMaxBudget() { return maxBudget; }
    public void setMaxBudget(Double maxBudget) { this.maxBudget = maxBudget; }

    public String getPreferredGender() { return preferredGender; }
    public void setPreferredGender(String preferredGender) { this.preferredGender = preferredGender; }

    public Integer getPreferredAgeMin() { return preferredAgeMin; }
    public void setPreferredAgeMin(Integer preferredAgeMin) { this.preferredAgeMin = preferredAgeMin; }

    public Integer getPreferredAgeMax() { return preferredAgeMax; }
    public void setPreferredAgeMax(Integer preferredAgeMax) { this.preferredAgeMax = preferredAgeMax; }
}
