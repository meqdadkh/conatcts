package com.meqdad.personal.web.conatcts.controller;

import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import com.meqdad.personal.web.conatcts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactService contactService;


    @RequestMapping(value = "/show-contacts", method = RequestMethod.GET)
    public String showContacts(ModelMap model) {
        return contactService.presentContacts(model);
    }
}
