package com.controllers;

import com.models.Response;
import com.services.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {
    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/topic/{topicId}")
    public List<Response> getResponsesByTopic(@PathVariable Long topicId) {
        return responseService.getResponsesByTopic(topicId);
    }

    @PostMapping
    public ResponseEntity<Response> createResponse(@RequestParam Long topicId, @RequestParam Long userId, @RequestParam String content) {
        Response response = responseService.createResponse(topicId, userId, content);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        responseService.deleteResponse(id);
        return ResponseEntity.noContent().build();
    }
}
