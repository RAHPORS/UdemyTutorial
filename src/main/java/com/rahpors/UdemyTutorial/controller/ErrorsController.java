package com.rahpors.UdemyTutorial.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ramon on 30/08/17.
 */

@ControllerAdvice
public class ErrorsController {

    public static String ISE_VIEW="error/500";
    @ExceptionHandler(Exception.class)
    public String showInternalServerError(){
        return ISE_VIEW;
    }
}
