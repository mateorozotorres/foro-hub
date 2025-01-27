package com.dtos;

import lombok.Data;

@Data
public class TopicDTO {
    private Long id;
    private String title;
    private String description;
    private Long userId; // ID del usuario creador
}
