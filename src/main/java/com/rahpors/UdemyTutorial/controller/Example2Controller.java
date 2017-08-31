package com.rahpors.UdemyTutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    //Forma 1
    //hostame/appname/example2/example1?nm=RAMON
    @RequestMapping(value = "/request1", method = RequestMethod.GET)
    public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "NULL") String name){
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("nm_inmodel",name);
        return modelAndView;
    }

    //forma 2
    //hostame/appname/example2/example1/RAMON
    @RequestMapping(value = "/request2/{nm}", method = RequestMethod.GET)
    public ModelAndView request2(@PathVariable("nm") String name){
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("nm_inmodel",name);
        return modelAndView;
    }
}
