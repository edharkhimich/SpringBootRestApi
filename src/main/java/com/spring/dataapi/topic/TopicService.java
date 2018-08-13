package com.spring.dataapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    List<Topic> getAllTopics() {
        return (List<Topic>) repository.findAll();
    }

    Optional<Topic> getTopic(String id) {
        return repository.findById(id);
    }

    void postTopic(Topic topic) {
        repository.save(topic);
    }

    void updateTopic(Topic topic, String id) {
        repository.save(topic);
    }

    void deleteTopic(String id){
        repository.deleteById(id);
    }
}
