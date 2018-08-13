package com.spring.dataapi.course;

import com.spring.dataapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.GET)
    public List<Course> getAllTopics(@PathVariable String topicId) {
        return service.getAllCourses(topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.GET)
    public Optional<Course> getCourseById(@PathVariable String id){
        return service.getCourse(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        service.postCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId){
        course.setTopic(new Topic(topicId, "", ""));
        service.updateCourse(course, courseId);
    }

    @RequestMapping(value = "topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)
    public void deleteTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId){
        course.setTopic(new Topic(topicId, "", ""));
        service.deleteCourse(courseId);
    }
}
