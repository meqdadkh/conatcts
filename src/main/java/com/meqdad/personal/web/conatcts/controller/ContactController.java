package com.meqdad.personal.web.conatcts.controller;

import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.service.ContactService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> findContacts() {
        return contactService.find();
    }

    @PostMapping
    public String addContact(@RequestBody Contact contact, BindingResult result) {
        return contactService.add(contact, result);
    }


}
