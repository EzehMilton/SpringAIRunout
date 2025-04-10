package com.chikere.Spring.AI.Demo.service;

import com.chikere.Spring.AI.Demo.model.Course;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class AIMCPService {

    // mock courses
    List <Course> courses = List.of(
            new Course("A black Girl", "A lost black girl in Nigeria"),
            new Course("Mbaise", "A short history of Mbaise"),
            new Course("Java Programming", "Learn Java basics")
    );

    @Tool(name = "get_courses", description = "Get all courses")
    List <Course> getCourses() {
        courses.forEach(course -> System.out.println(course.title()));
        return courses;
    }

    @Tool(name = "find_course", description = "Get course by title")
    Course getCourse(String title) {
        return courses.stream()
                .filter(course -> course.title()
                .equalsIgnoreCase(title))
                .findFirst().
                orElse(null);
    }
}
