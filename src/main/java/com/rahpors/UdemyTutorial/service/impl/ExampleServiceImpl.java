package com.rahpors.UdemyTutorial.service.impl;

import com.rahpors.UdemyTutorial.model.Person;
import com.rahpors.UdemyTutorial.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon on 30/08/17.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

    private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ramon",23));
        people.add(new Person("Naye",23));
        people.add(new Person("Glori",21));
        LOG.info("HELLO FROM SERVICE");
        return people;
    }
}
