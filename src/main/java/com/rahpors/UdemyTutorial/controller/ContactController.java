package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.constant.ViewConstant;
import com.rahpors.UdemyTutorial.entity.Contact;
import com.rahpors.UdemyTutorial.model.ContactModel;
import com.rahpors.UdemyTutorial.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ramon on 5/09/17.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @GetMapping("/cancel")
    private String cancel(){
        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/contactform")
    private String redirectContactForm(@RequestParam(name = "id", required = false)int id, Model model){
        ContactModel contactModel = new ContactModel();
        if(id!=0){
            contactModel=contactService.findContactById(id);
        }
        model.addAttribute("contactModel", contactModel );
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addContact")
    private String addContact(@ModelAttribute("contactModel")ContactModel contactModel, Model model){
        LOG.info("METHOD: addContact() Params: "+ contactModel.toString());
        if(null != contactService.addContact(contactModel)){
            model.addAttribute("result", 1);
        }
        else{
            model.addAttribute("result", 0);
        }
        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/showcontacts")
    private ModelAndView showContacts(){
        ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS_FORM);
        modelAndView.addObject("contacts",contactService.listAllContacts());
        return modelAndView;
    }

    @GetMapping("/removecontact")
    private ModelAndView removeContact(@RequestParam(name = "id", required = true) int id){
        ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS_FORM);
        contactService.removeContact(id);
        modelAndView.addObject("contacts",contactService.listAllContacts());
        return modelAndView;
    }





}
