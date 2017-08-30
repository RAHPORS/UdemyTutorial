package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by ramon on 29/08/17.
 */
@Controller
@RequestMapping("/example4")
public class Example4Controller {

    public static final String EXAMPLE_VIEW = "404";

    @GetMapping("/error")
    public ModelAndView error(Model model) {
        ModelAndView modelAndView  = new ModelAndView(EXAMPLE_VIEW);
        int a=6/0;
        return modelAndView;
    }
}