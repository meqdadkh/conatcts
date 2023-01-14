package com.meqdad.personal.web.conatcts.controller;

import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(value = "/show-contacts", method = RequestMethod.GET)
    public String showContacts(ModelMap model) {
        model.put("contacts", contactRepository.findAll());
        return "show-contacts";
    }
}
