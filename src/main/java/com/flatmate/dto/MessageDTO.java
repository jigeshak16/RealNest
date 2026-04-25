package com.flatmate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO {

    private Long senderId;
    private String content;
}
