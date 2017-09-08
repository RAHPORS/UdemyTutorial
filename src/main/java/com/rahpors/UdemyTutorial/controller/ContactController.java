package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.constant.ViewConstant;
import com.rahpors.UdemyTutorial.model.ContactModel;
import com.rahpors.UdemyTutorial.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ramon on 5/09/17.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

    public static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    public ContactService contactService;

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/contacts/showcontacts";
    }


    @GetMapping("/contactform")
    public String redirectContactForm(@RequestParam(name = "id", required = false)int id, Model model){
        ContactModel contactModel = new ContactModel();
        if(id!=0){
            contactModel=contactService.findContactById(id);
        }
        model.addAttribute("contactModel", contactModel );
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addContact")
    public String addContact(@ModelAttribute("contactModel")ContactModel contactModel, Model model){
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
    public ModelAndView showContacts(){

        ModelAndView modelAndView = new ModelAndView("contacts");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelAndView.addObject("username", user.getUsername());
        List<ContactModel> list = contactService.listAllContacts();
        modelAndView.addObject("contacts", list);
        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/removecontact")
    public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id){
        ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS_FORM);
        contactService.removeContact(id);
        modelAndView.addObject("contacts",contactService.listAllContacts());
        return modelAndView;
    }





}
