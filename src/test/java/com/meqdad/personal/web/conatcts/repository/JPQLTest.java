package com.meqdad.personal.web.conatcts.repository;

import com.meqdad.personal.web.conatcts.ConatctsApplication;
import com.meqdad.personal.web.conatcts.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConatctsApplication.class)
public class JPQLTest {

    @Autowired
    private ContactRepository contactRepository;

    public JPQLTest() {

    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @Transactional
    public void jpql_select_basic() {
        List<Contact> contacts = contactRepository.contactsJpqlQuerySelect();
        logger.info(contacts.toString());
    }

    @Test
    @Transactional
    public void jpql_update_basic() {
        contactRepository.contactsJpqlQueryUpdate();
    }

    @Test
    @Transactional
    public void contactsWithoutLabels() {
        List<Contact> contacts = contactRepository.contactsWithoutLabelsJpql();
        logger.info("Contacts without labels are -> " + contacts);
    }

    @Test
    @Transactional
    public void contactsWithatleast2Labels() {
        List<Contact> contacts = contactRepository.contactsWithAtleast2LabelsJpql();
        logger.info("Contacts with atleast 2 labels are -> " + contacts);
    }

    @Test
    @Transactional
    public void contactsOrderBySizeOfLabels() {
        List<Contact> contacts = contactRepository.contactsOrderBySizeOfLabelsJpql();
        logger.info("Contacts ordered by size of labels are -> " + contacts);
    }

    @Test
    @Transactional
    public void contactsWithCertainPatternInEntryContent() {
        List<Contact> contacts = contactRepository.contactsWithCertainPatternInEntryContentJpql();
        logger.info("Contacts with certain pattern in entry content are -> " + contacts);
    }
}
