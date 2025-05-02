package com.project.hamroschool.service;

import com.project.hamroschool.model.Constants;
import com.project.hamroschool.model.Contact;
import com.project.hamroschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

@Service
//@RequestScope
//@SessionScope
//@ApplicationScope
@SessionScope
public class ContactService {

    ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean saveContactMessage(Contact contact) {
        boolean isSaved = false;
        contact.setCreatedat(LocalDateTime.now());
        contact.setCreatedby(Constants.ANYNOMOUS);
        contact.setStatus(Constants.OPEN);
        int check = contactRepository.StoretoDataBase(contact);
        if (check > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public int closeMsg(int contactId) {
        //  contactRepository.closeMsgInDataBase(int contactId);
       return contactRepository.closeMsgInDataBase(contactId);
    }
}