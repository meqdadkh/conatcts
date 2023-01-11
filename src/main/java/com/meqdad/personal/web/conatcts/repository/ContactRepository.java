package com.meqdad.personal.web.conatcts.repository;

import com.meqdad.personal.web.conatcts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
