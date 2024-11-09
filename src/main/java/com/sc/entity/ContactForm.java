package com.sc.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_form")
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String message;
    private LocalDateTime submittedAt;
	public void setSubmittedAt(LocalDateTime now) {
		this.submittedAt = submittedAt;	
	}
}
