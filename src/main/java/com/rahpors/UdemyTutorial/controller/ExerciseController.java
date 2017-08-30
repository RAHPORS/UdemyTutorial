package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.componet.ExampleComponent;
import com.rahpors.UdemyTutorial.service.ExampleService;
import com.rahpors.UdemyTutorial.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by ramon on 29/08/17.
 */
@Controller
@RequestMapping("/exercise")
public class ExerciseController {
    private static final Log LOG = LogFactory.getLog(ExerciseController.class);

    @Autowired
    @Qualifier("exerciseService")
    ExerciseService exerciseService;

    @GetMapping("/method")
    public RedirectView redirect(){
        return new RedirectView("../exercise/implementation");
    }

    @GetMapping("/implementation")
    public ModelAndView implementation(){
        long startTime = System.currentTimeMillis();
        ModelAndView modelAndView = new ModelAndView("exercise");
        modelAndView.addObject("message", exerciseService.writeInLog());
        LOG.info(System.currentTimeMillis()-startTime);
        modelAndView.addObject("time", System.currentTimeMillis()-startTime);

        return modelAndView;
    }

}
