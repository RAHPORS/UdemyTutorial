package com.rahpors.UdemyTutorial.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.rahpors.UdemyTutorial.entity.Course;
import com.rahpors.UdemyTutorial.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ramon on 31/08/17.
 */

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager entityManager;

    public void find(){
        JPAQuery<Course> query = new JPAQuery<Course>(entityManager);

        query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

        List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20,50)).fetch();
    }
}
