package com.meqdad.personal.web.conatcts.service;

import com.meqdad.personal.web.conatcts.dto.ContactEntryDto;
import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> fetchContactsNamesOnly() {
        return contactRepository.findAll();
    }

    //public List<ContactEntryDto> fetchContactsWithNames() {
    public void fetchContactsWithNames() {
        //return contactRepository.findAll();
    }
}
