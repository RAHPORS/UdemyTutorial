package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ramon on 7/09/17.
 */

@RestController
@RequestMapping("/rest")
public class RestControllers {
    @GetMapping("/checkrest")
    public ResponseEntity<ContactModel> checkRest(){
        ContactModel contactModel = new ContactModel(1,"ramon","Herna","331206","GDL");
        return  new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
    }
}
