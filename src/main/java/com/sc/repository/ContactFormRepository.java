package com.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sc.entity.ContactForm;

public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
}
