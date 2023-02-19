package com.meqdad.personal.web.conatcts.controller;

import com.meqdad.personal.web.conatcts.exception.ContactNotFoundException;
import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.model.Entry;
import com.meqdad.personal.web.conatcts.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> findContacts() {
        return contactService.find();
    }

    @GetMapping("/{id}")
    public Optional<Contact> findContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.findById(id);
        if (!contact.isPresent())
            throw new ContactNotFoundException("id - " + id);
        return contact;
    }

    @GetMapping("/{id}/entries")
    public List<Entry> findEntriesByContactId(@PathVariable Long id) {
        List<Entry> entries = contactService.findContactEntries(id);
        if (entries == null)
            throw new ContactNotFoundException("id - " + id);
        return entries;
    }

    @GetMapping("/{id}/entries/{entryId}")
    public Optional<Entry> findEntryByContactId(@PathVariable Long id, @PathVariable Long entryId) {
        Optional<Entry> entry = Optional.ofNullable(contactService.findSpecialContactEntry(id, entryId));
        if (!entry.isPresent())
            throw new ContactNotFoundException("id - " + id);
        return entry;
    }


    @PostMapping
    public ResponseEntity<Object> addContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.add(contact);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedContact.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/{id}")
    public String updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return contactService.update(id, contact);
    }

    @PostMapping("/{id}/entries")
    public ResponseEntity<Object> addEntry(@PathVariable Long contactId, @RequestBody Entry entry) {
        Entry savesEntry = contactService.addEntry(contactId, entry);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/entries").buildAndExpand(savesEntry.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.delete(id);
    }

    @GetMapping("/contactsJpqlQueryUpdate")
    public int contactsJpqlQueryUpdate() {
        return contactService.contactsJpqlQueryUpdate();
    }
}
