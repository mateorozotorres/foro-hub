package com.services;

import com.models.Response;
import com.models.Topic;
import com.models.User;
import com.repositories.ResponseRepository;
import com.repositories.TopicRepository;
import com.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    private final ResponseRepository responseRepository;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public ResponseService(ResponseRepository responseRepository, TopicRepository topicRepository, UserRepository userRepository) {
        this.responseRepository = responseRepository;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    public List<Response> getResponsesByTopic(Long topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
        return topic.getResponses();
    }

    public Response createResponse(Long topicId, Long userId, String content) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Response response = new Response();
        response.setContent(content);
        response.setTopic(topic);
        response.setUser(user);
        return responseRepository.save(response);
    }

    public void deleteResponse(Long id) {
        responseRepository.deleteById(id);
    }
}
