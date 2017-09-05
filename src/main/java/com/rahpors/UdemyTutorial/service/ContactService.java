package com.rahpors.UdemyTutorial.service;

import com.rahpors.UdemyTutorial.entity.Contact;
import com.rahpors.UdemyTutorial.model.ContactModel;

import java.util.List;

/**
 * Created by ramon on 5/09/17.
 */
public interface ContactService {
    public abstract ContactModel addContact(ContactModel contactModel);

    public abstract List<ContactModel> listAllContacts();

    public abstract ContactModel findContactById(int id);

    public abstract void removeContact(int id);
}
