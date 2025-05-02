package com.project.hamroschool.controller;

import com.project.hamroschool.model.Contact;
import com.project.hamroschool.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String contact (Model model) {
        model.addAttribute("contactobj", new Contact());
        model.addAttribute("success",false);
        return "contact";
    }

    @PostMapping("/saveMsg")
    public String saveMsg(@Valid @ModelAttribute(name = "contactobj") Contact contact, Errors errors,Model model) {
        if (errors.hasErrors()) {
            // Log all the errors, you can customize this to display user-friendly messages
            errors.getAllErrors().forEach(error -> {
                System.out.println("Contact form validation failed due to: " + error.getDefaultMessage());
            });
            return "contact"; // jun aabasta ma xa tai aabasta ma display gar
        }

        // If validation passes, save the contact message
        boolean isSaved= contactService.saveContactMessage(contact);
        model.addAttribute("success",isSaved);
        return "redirect:/contact"; // Naya aawasta ma return vai
    }


    @GetMapping("/closeMsg")
    public String closeMsg(@RequestParam int contactId) {
        contactService.closeMsg(contactId);
        return"redirect:/messages";
    }
}
