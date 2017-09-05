package com.rahpors.UdemyTutorial.repository;

import com.rahpors.UdemyTutorial.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ramon on 5/09/17.
 */

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact,Serializable>{
    public abstract Contact findById(int id);

}
