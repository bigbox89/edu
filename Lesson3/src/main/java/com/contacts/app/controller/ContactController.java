package com.contacts.app.controller;

import com.contacts.app.entity.Contact;
import com.contacts.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String showContactList(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        model.addAttribute("newContact", new Contact());
        return "index";
    }

    @PostMapping("/addContact")
    public String addContact(@ModelAttribute("newContact") Contact contact) {
        contactService.addContact(contact);
        return "redirect:/";
    }

    @PostMapping ("/updateContact/{id}")
    public String updateContact(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String phone) {
        Contact contact = contactService.getContactById(id).get();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setEmail(email);
        contact.setPhone(phone);
        contactService.updateContact(contact);
        return "redirect:/";
    }
    @PostMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return "redirect:/";
    }
}
