package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.view.RedirectView;

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
    public static final String RESULT_VIEW = "form";

    //Forma 1
//    @GetMapping("/")
//    public String redirect(){
//        return "redirect:/example3/showform";
//    }

    //Forma 2
    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("../example3/showform");
    }

    @GetMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("person", new Person());
        return EXAMPLE_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
        modelAndView.addObject("person", person);
        return modelAndView;
    }

}
