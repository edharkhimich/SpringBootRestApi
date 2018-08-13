package com.spring.dataapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService service;

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
        return service.getAllTopics();
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    public Optional<Topic> getTopicById(@PathVariable String id){
        return service.getTopic(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void postTopic(@RequestBody Topic topic){
        service.postTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        service.updateTopic(topic, id);
    }

    @RequestMapping(value = "topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        service.deleteTopic(id);
    }

}
