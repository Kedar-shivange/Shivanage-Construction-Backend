package com.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sc.entity.ContactForm;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {

}
