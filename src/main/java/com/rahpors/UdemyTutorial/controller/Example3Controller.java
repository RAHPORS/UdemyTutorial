package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.jws.WebParam;
import java.util.Collection;
import java.util.Map;

/**
 * Created by ramon on 29/08/17.
 */
@Controller
@RequestMapping("/example3")
public class Example3Controller {

    public static final String EXAMPLE_VIEW = "form";

    @GetMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("person", new Person());
        return EXAMPLE_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("person", person);
        return modelAndView;
    }

}
