package com.meqdad.personal.web.conatcts.repository;

import com.meqdad.personal.web.conatcts.ConatctsApplication;
import com.meqdad.personal.web.conatcts.model.Address;
import com.meqdad.personal.web.conatcts.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConatctsApplication.class)
public class ContactRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    /*public ContactRepositoryTest(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }*/

    EntityManager entityManager;

    public ContactRepositoryTest() {

    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById_basic() {
        Optional<Contact> contact = contactRepository.findById(20001L);
        assertTrue(contact.isPresent());
        assertEquals("Meqdad",contact.get().getFirstName());
        assertThat(contact.get().getFirstName()).isEqualTo("Meqdad");
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        contactRepository.deleteById(20002L);
        assertEquals(Optional.empty(), contactRepository.findById(20002L));
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        Optional<Contact> contact = contactRepository.findById(20001L);
        contact.get().setFirstName("Esmaeil");
        contactRepository.save(contact.orElse(null));

        Optional<Contact> contact1 = contactRepository.findById(20001L);

        assertEquals("Esmaeil", contact1.get().getFirstName());
    }

    @Test
    public void sortFindAll() {
        logger.info("Sorted Contacts:" + contactRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName")));
    }

    @Test
    public void pageableFindAll() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "firstName"));
        Page<Contact> firstPage = contactRepository.findAll(pageRequest);
        logger.info("First Page:" + firstPage.getContent());
    }

    @Test
    public void findUsingFirstName() {
        logger.info("Find by name: " + contactRepository.findByFirstName("Meqdad"));
    }

    @Test
    public void setAddressDetails() {
        Optional<Contact> contact = contactRepository.findById(20001L);
        contact.get().setAddress(new Address("No101", "Some Street", "Tehran"));
        contactRepository.save(contact.orElse(null));
    }
}

