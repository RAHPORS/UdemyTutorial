package com.rahpors.UdemyTutorial.repository;

import com.rahpors.UdemyTutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ramon on 30/08/17.
 */

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course,Serializable> {
    public abstract Course findByPrice(int price);

    public abstract Course findByPriceAndName(int price, String name);
}
