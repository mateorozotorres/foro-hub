package com.mappers;

import com.dtos.ResponseDTO;
import com.models.Response;

public class ResponseMapper {
    public static ResponseDTO toDTO(Response response) {
        ResponseDTO dto = new ResponseDTO();
        dto.setId(response.getId());
        dto.setContent(response.getContent());
        dto.setTopicId(response.getTopic().getId());
        dto.setUserId(response.getUser().getId());
        return dto;
    }
}
