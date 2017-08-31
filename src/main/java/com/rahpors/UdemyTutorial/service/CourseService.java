package com.rahpors.UdemyTutorial.service;

import com.rahpors.UdemyTutorial.entity.Course;

import java.util.List;

public interface CourseService {
    public abstract List<Course> listAllCourse();
    public abstract Course addCourse(Course course);
    public abstract int removeCourse(int id);
    public abstract Course updateCourse(Course course);

}
