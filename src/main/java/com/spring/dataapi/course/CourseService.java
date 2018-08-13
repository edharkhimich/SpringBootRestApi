package com.spring.dataapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

        @Autowired
        private CourseRepository repository;

        List<Course> getAllCourses(String topicId) {
            return repository.findByTopicId(topicId);
        }

        Optional<Course> getCourse(String id) {
            return repository.findById(id);
        }

        void postCourse(Course course) {
            repository.save(course);
        }

        void updateCourse(Course course, String id) {
            repository.save(course);
        }

        void deleteCourse(String id) {
            repository.deleteById(id);
        }

}
