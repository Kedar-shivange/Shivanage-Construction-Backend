package com.sc.controller;
import com.sc.entity.ContactMessage;
import com.sc.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
public class ContactMessageController {
@Autowired
private ContactMessageService contactMessageService;

@GetMapping
public List<ContactMessage> getAllContactMessages() {
   return contactMessageService.getAllContactMessages();
}

@GetMapping("/{id}")
public ResponseEntity<ContactMessage> getContactMessageById(@PathVariable Long id) {
   ContactMessage contactMessage = contactMessageService.getContactMessageById(id);
   return contactMessage != null ? ResponseEntity.ok(contactMessage) : ResponseEntity.notFound().build();
}

@PostMapping
public ContactMessage createContactMessage(@RequestBody ContactMessage contactMessage) {
   return contactMessageService.saveContactMessage(contactMessage);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteContactMessage(@PathVariable Long id) {
   ContactMessage contactMessage = contactMessageService.getContactMessageById(id);
   if (contactMessage == null) {
       return ResponseEntity.notFound().build();
   }
   contactMessageService.deleteContactMessage(id);
   return ResponseEntity.ok().build();
}
}