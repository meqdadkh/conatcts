package com.meqdad.personal.web.conatcts.service;

import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

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

    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public String update(Long id, Contact contact) {
        contact.setId(id);
        contactRepository.save(contact);
        return "redirect:/";
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    public int contactsJpqlQueryUpdate() {
        return contactRepository.contactsJpqlQueryUpdate();
    }
}
