package com.meqdad.personal.web.conatcts.repository;

import com.meqdad.personal.web.conatcts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByFirstName(String firstName);

    @Query("select c from Contact c")
    List<Contact> contactsJpqlQuerySelect();

    @Modifying
    @Transactional
    @Query("update Contact c set c.firstName = 'Ali' where c.Id = 20001")
    int contactsJpqlQueryUpdate();

    @Query("select c from Contact c where c.labels is empty ")
    List<Contact> contactsWithoutLabelsJpql();

    @Query("select c from Contact c where size(c.labels) >= 2")
    List<Contact> contactsWithAtleast2LabelsJpql();

    @Query("select c from Contact c order by size(c.labels)")
    List<Contact> contactsOrderBySizeOfLabelsJpql();

    /*@Query("select c from Contact c where c.entries.content like '%09%'")
    List<Contact> contactsWithCertainPatternInEntryContentJpql();*/

    @Query("select c, e from Contact c join c.entries e")
    List<Object[]> joinJpql();
}
