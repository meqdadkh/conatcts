package com.meqdad.personal.web.conatcts.repository;

import com.meqdad.personal.web.conatcts.dto.ContactEntryDto;
import com.meqdad.personal.web.conatcts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("FROM Contact WHERE ")
    List<ContactEntryDto> contactsJoinEntries();
}
