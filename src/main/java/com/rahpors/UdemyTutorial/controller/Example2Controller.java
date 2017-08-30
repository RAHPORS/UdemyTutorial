package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon on 29/08/17.
 */
@Controller
@RequestMapping("/example2")
public class Example2Controller {

    public static final String EXAMPLE_VIEW = "example2";

    @RequestMapping(value = "/example1", method = RequestMethod.GET)
    public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "NULL") String name){
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("nm_inmodel",name);
        return modelAndView;
    }

}
