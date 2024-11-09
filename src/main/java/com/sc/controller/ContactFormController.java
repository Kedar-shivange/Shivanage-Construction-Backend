package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.entity.ContactForm;
import com.sc.service.ContactFormService;

@RestController
@RequestMapping("/api/contact")
public class ContactFormController {

    @Autowired
    private ContactFormService service;

    @PostMapping("/submit")
    public ResponseEntity<String> submitContactForm(@RequestBody ContactForm contactForm) {
        service.saveContactForm(contactForm);
        return ResponseEntity.ok("Form submitted successfully");
    }
}
