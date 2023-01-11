package com.meqdad.personal.web.conatcts.controller;

import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping(value = "/show-Contacts")
    public String showContacts(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "show-Contacts";
    }
}
