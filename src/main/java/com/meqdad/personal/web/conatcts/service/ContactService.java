package com.meqdad.personal.web.conatcts.service;

import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public String showContacts(ModelMap model) {
        model.put("contacts", contactRepository.findAll());
        return "show-contacts";
    }
}
