package com.dtos;

import lombok.Data;

@Data
public class ResponseDTO {
    private Long id;
    private String content;
    private Long topicId; // ID del tópico relacionado
    private Long userId;  // ID del usuario que creó la respuesta
}
