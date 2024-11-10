package com.sc.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sc.entity.ContactForm;
import com.sc.repository.ContactFormRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Adjust based on your frontend port
public class ContactFormController {

    @Autowired
    private ContactFormRepository contactFormRepository;

    @PostMapping("/contact")
    public ResponseEntity<?> submitContactForm(@RequestBody ContactForm contactForm) {
        contactForm.setSubmittedAt(LocalDateTime.now());
        contactFormRepository.save(contactForm);
        return ResponseEntity.ok("{\"message\": \"Form submitted successfully\"}");
    }
}
