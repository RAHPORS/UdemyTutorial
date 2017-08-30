package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.componet.ExampleComponent;
import com.rahpors.UdemyTutorial.model.Person;
import com.rahpors.UdemyTutorial.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon on 29/08/17.
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;
    //Primer forma
    @GetMapping("/exampleString")
    public String exampleString(Model model){
        exampleComponent.sayHello();
        model.addAttribute("people",exampleService.getListPeople());
        return EXAMPLE_VIEW;
    }

    //Segunda forma
    @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
    public ModelAndView exampleMAV(){
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("people",exampleService.getListPeople());
        return modelAndView;
    }


}
