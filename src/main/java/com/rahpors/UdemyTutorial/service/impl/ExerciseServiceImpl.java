package com.rahpors.UdemyTutorial.service.impl;

import com.rahpors.UdemyTutorial.model.Person;
import com.rahpors.UdemyTutorial.service.ExampleService;
import com.rahpors.UdemyTutorial.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon on 30/08/17.
 */
@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService{

    private static final Log LOG = LogFactory.getLog(ExerciseServiceImpl.class);

    @Override
    public String writeInLog() {
        String message = "MENSAJE DEL EJERCICIO";
        LOG.info(message);
        return message;
    }
}
