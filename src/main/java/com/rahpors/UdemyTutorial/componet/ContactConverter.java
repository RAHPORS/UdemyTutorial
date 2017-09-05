package com.rahpors.UdemyTutorial.componet;

import com.rahpors.UdemyTutorial.entity.Contact;
import com.rahpors.UdemyTutorial.model.ContactModel;
import org.springframework.stereotype.Component;

/**
 * Created by ramon on 5/09/17.
 */

@Component("contactConverter")
public class ContactConverter {

    public Contact contactModelToContact(ContactModel contactModel ){
        Contact contact = new Contact(
                contactModel.getId(),
                contactModel.getFirstname(),
                contactModel.getLastname(),
                contactModel.getTelephone(),
                contactModel.getCity()
        );
        return contact;
    }

    public ContactModel contactToContactModel(Contact contact){
        ContactModel contactModel = new ContactModel(
                contact.getId(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getTelephone(),
                contact.getCity()
        );
        return contactModel;
    }

}
