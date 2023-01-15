package com.meqdad.personal.web.conatcts.repository;

import com.meqdad.personal.web.conatcts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select c from Contact c inner join c.entries e")
    List<Contact> findContactByEntryId();
}
