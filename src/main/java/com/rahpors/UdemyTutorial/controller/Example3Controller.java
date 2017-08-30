package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

/**
 * Created by ramon on 29/08/17.
 */
@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

    public static final String EXAMPLE_VIEW = "form";
    public static final String RESULT_VIEW = "result";

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
        LOGGER.info("INFO");
        LOGGER.warn("WARN");
        LOGGER.error("ERROR");
        LOGGER.debug("DEBUG");
        model.addAttribute("person", new Person());
        return EXAMPLE_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.setViewName(EXAMPLE_VIEW);
        }
        else {
            modelAndView.setViewName(RESULT_VIEW);
            modelAndView.addObject("person", person);
        }
        return modelAndView;
    }

}
