package com.meqdad.personal.web.conatcts.repository;

import com.meqdad.personal.web.conatcts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select c from Contact c")
    List<Contact> contactsJpqlQuerySelect();

    @Modifying
    @Transactional
    @Query("update Contact c set c.firstName = 'Ali' where c.Id = 20001")
    int contactsJpqlQueryUpdate();
}
