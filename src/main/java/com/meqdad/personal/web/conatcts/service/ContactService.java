package com.meqdad.personal.web.conatcts.service;

import com.meqdad.personal.web.conatcts.model.Contact;
import com.meqdad.personal.web.conatcts.model.Entry;
import com.meqdad.personal.web.conatcts.repository.ContactRepository;
import com.meqdad.personal.web.conatcts.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final EntryRepository entryRepository;

    public ContactService(ContactRepository contactRepository, EntryRepository entryRepository) {
        this.contactRepository = contactRepository;
        this.entryRepository = entryRepository;
    }

    public List<Contact> find() {
        return contactRepository.findAll();
    }

    public Contact add(Contact contact) {

        return contactRepository.save(contact);
    }

    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public List<Entry> findContactEntries(Long id) {
        Optional<Contact> contact = findById(id);
        if (contact.isPresent()) {
            List<Entry> entries = contact.get().getEntries();
            if (!entries.isEmpty())
                return entries;
        }
        return null;
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

    public Entry addEntry(Long id, Entry entry) {
        Entry savedEntry = entryRepository.save(entry);
        Contact contact = findById(id).get();
        List<Entry> entries = contact.getEntries();
        entries.add(entry);
        contact.setEntries(entries);
        update(id,contact);
        return savedEntry;


    }

    public Entry findSpecialContactEntry(Long id, Long entryId) {
        Optional<Contact> contact = findById(id);
        if (contact.isPresent()) {
            List<Entry> entries = contact.get().getEntries();
            for (Entry entry: entries)
                if(entry.getId().equals(entryId))
                    return entry;
        }
        return null;
    }
}
