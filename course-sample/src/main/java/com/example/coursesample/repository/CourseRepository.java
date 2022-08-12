package com.example.coursesample.repository;

import com.example.coursesample.database.FakeDB;
import com.example.coursesample.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    // Repository : Chứa các phương thức để thao tác với database

    // Ví dụ demo
    // Lấy danh sách tất cả khóa học
    public List<Course> getAll(String title, String topic) {
        if (title !=null){
            if (topic == null){
                return getByTitle(title);
            }
            return getByTopicAndTitle(title, topic);
        }else {
            if (topic!=null){
                return getByTopic(topic);
            }
            return FakeDB.courses;
        }
    }

    public List<Course> getByType(String type) {
        return FakeDB.courses.stream()
                .filter(course -> Objects.equals(course.getType(), type))
                .collect(Collectors.toList());
    }
    //tim theo id
    public Course getById(int id){
        return FakeDB.courses.stream()
                .filter(course -> course.getId()==id)
                .findFirst().get();
    }

    public List<Course> getByTitle(String title){
            return FakeDB.courses.stream()
                    .filter(course -> course.getTitle().contains(title))
                    .collect(Collectors.toList());
    }

    public List<Course> getByTopic(String topic){
        return FakeDB.courses.stream()
                .filter(course -> course.getTopics().contains(topic))
                .collect(Collectors.toList());
    }

    public List<Course> getByTopicAndTitle( String title, String topic){
        return FakeDB.courses.stream()
                .filter(course -> course.getTopics().contains(topic))
                .filter(course -> course.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Course> getByType(String type, String title, String topic){
        if (title != null){
            if (topic == null){
                return getByTitle(title)
                        .stream()
                        .filter(course -> course.getType().contains(type))
                        .collect(Collectors.toList());
            }
            return getByTopicAndTitle(title,topic).stream()
                    .filter(course -> course.getType().contains(type))
                    .collect(Collectors.toList());
        }else {
            if (topic != null){
                return getByTopic(topic)
                        .stream()
                        .filter(course -> course.getType().contains(type))
                        .collect(Collectors.toList());
            }
            return getByType(type);
        }
    }


}
