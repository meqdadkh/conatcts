package com.meqdad.personal.web.conatcts.controller;

import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import com.meqdad.personal.web.conatcts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactService contactService;


    @GetMapping(value = "/show-contacts-names-only")
    public List<Contact> showContactsNamesOnly(ModelMap model) {
        return contactService.fetchContactsNamesOnly();
    }

    @GetMapping(value = "/show-contacts-with-number")
    //public List<Contact> showContacts(ModelMap model) {
    public List<Contact> showContacts(ModelMap model) {
        return contactService.fetchContactsWithEntries();
    }
}
