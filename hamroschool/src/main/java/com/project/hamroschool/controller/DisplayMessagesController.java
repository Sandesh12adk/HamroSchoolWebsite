package com.project.hamroschool.controller;

import com.project.hamroschool.model.Constants;
import com.project.hamroschool.model.Contact;
import com.project.hamroschool.model.ContactRowMapper;
import com.project.hamroschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.PreparedStatement;
import java.util.List;

@Controller
public class DisplayMessagesController {
    ContactRepository contactRepository;
    @Autowired
    public DisplayMessagesController(ContactRepository contactRepository){
        this.contactRepository= contactRepository;
    }

    @GetMapping("/messages")
    public ModelAndView messages(){
        List<Contact> contactmsgs= contactRepository.findMessagesWithOpenStatus(Constants.OPEN);
        ModelAndView mav= new ModelAndView();
        mav.setViewName("messages");
        mav.addObject("contactmsgs",contactmsgs);
        return mav;
    }
    @GetMapping("/msg")
    public Contact msg(){
      //  List<Contact> contactmsg= contactRepository.findMessagesWithOpenStatus(Constants.OPEN);
      Contact contact= new Contact();
      contact.setMessage("Hi, this is contact message");
      return contact;
    }

}
