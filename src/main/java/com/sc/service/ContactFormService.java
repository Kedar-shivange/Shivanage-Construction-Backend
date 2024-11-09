package com.sc.service;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sc.entity.ContactForm;
import com.sc.repository.ContactFormRepository;

@Service
public class ContactFormService {

    @Autowired
    private ContactFormRepository repository;

    // Method to save contact form with the current submission time
    public void saveContactForm(ContactForm contactForm) {
        // Set the submission time
        contactForm.setSubmittedAt(LocalDateTime.now());
        
        // Save the contact form to the database
        repository.save(contactForm);
    }
}
