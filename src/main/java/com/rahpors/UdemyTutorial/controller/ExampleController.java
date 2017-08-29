package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.model.Person;
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

    //Primer forma
    @GetMapping("/exampleString")
    public String exampleString(Model model){
        model.addAttribute("people",getPeople());
        return EXAMPLE_VIEW;
    }

    //Segunda forma
    @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
    public ModelAndView exampleMAV(){
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("people",getPeople());
        return modelAndView;
    }

    private List<Person> getPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ramon",23));
        people.add(new Person("Naye",23));
        people.add(new Person("Glori",21));
        return people;
    }
}
