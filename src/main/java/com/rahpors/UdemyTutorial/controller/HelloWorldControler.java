package com.rahpors.UdemyTutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ramon on 29/08/17.
 */

@Controller
@RequestMapping("/say")
public class HelloWorldControler {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "helloworld";
    }

}
