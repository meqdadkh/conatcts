package com.meqdad.personal.web.conatcts.service;

import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> find() {
        return contactRepository.findAll();
    }

    public String add(Contact contact, BindingResult result) {
        if (result.hasErrors())
            return "contact";

        contactRepository.save(contact);
        return "redirect:/";
    }
}
