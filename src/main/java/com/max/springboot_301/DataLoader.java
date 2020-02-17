package com.max.springboot_301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CourseRepository repository;

    @Override
    public void run(String ... strings) throws Exception{
        Course course;
        course = new Course("Astrophysics", "Neil D Tyson","Just a course on stars", 3);
        repository.save(course);

    }
}
