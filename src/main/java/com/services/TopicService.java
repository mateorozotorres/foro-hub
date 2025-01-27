package com.services;

import com.models.Topic;
import com.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
