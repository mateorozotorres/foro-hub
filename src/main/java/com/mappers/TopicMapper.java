package com.mappers;

import com.dtos.TopicDTO;
import com.models.Topic;

public class TopicMapper {
    public static TopicDTO toDTO(Topic topic) {
        TopicDTO dto = new TopicDTO();
        dto.setId(topic.getId());
        dto.setTitle(topic.getTitle());
        dto.setDescription(topic.getDescription());
        dto.setUserId(topic.getUser().getId());
        return dto;
    }

    public static Topic toEntity(TopicDTO dto) {
        Topic topic = new Topic();
        topic.setId(dto.getId());
        topic.setTitle(dto.getTitle());
        topic.setDescription(dto.getDescription());
        return topic;
    }
}
