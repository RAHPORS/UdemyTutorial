package com.rahpors.UdemyTutorial.service.impl;

import com.rahpors.UdemyTutorial.componet.ContactConverter;
import com.rahpors.UdemyTutorial.controller.ContactController;
import com.rahpors.UdemyTutorial.entity.Contact;
import com.rahpors.UdemyTutorial.model.ContactModel;
import com.rahpors.UdemyTutorial.repository.ContactRepository;
import com.rahpors.UdemyTutorial.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon on 5/09/17.
 */

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.contactModelToContact(contactModel));
        return contactConverter.contactToContactModel(contact);

    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactModels = new ArrayList<ContactModel>();
        for(Contact contact: contacts){
            contactModels.add(contactConverter.contactToContactModel(contact));
        }
        return contactModels;
    }

    @Override
    public ContactModel findContactById(int id) {
        return contactConverter.contactToContactModel(contactRepository.findById(id));
    }

    @Override
    public void removeContact(int id) {
        Contact contact = contactConverter.contactModelToContact(findContactById(id));
        if(contact!=null){
            contactRepository.delete(contact);
        }
    }
}
