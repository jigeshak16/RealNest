package com.flatmate.dto;

import com.flatmate.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String email;
    private String fullName;
    private String phone;
    private String profilePicture;
    private String userType;
    private String gender;
    private Integer age;
    private String bio;
    private String location;
    private Boolean isActive;

    public static UserDTO fromEntity(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .profilePicture(user.getProfilePicture())
                .userType(user.getUserType() != null
                        ? user.getUserType().name()
                        : null)
                .gender(user.getGender() != null
                        ? user.getGender().name()
                        : null)
                .age(user.getAge())
                .bio(user.getBio())
                .location(user.getLocation())
                .isActive(user.getIsActive())
                .build();
    }
}