package com.meqdad.personal.web.conatcts.service;

import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> fetchContactsNamesOnly() {
        return contactRepository.findAll();
    }

    //public List<ContactEntryDto> fetchContactsWithNames() {
    public List<Contact> fetchContactsWithEntries() {
        return contactRepository.findContactByEntryId();
    }
}
