package com.sc.service;

import com.sc.entity.ContactMessage;
import com.sc.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactMessageService {
@Autowired
private ContactMessageRepository contactMessageRepository;

public List<ContactMessage> getAllContactMessages() {
   return contactMessageRepository.findAll();
}

public ContactMessage getContactMessageById(Long id) {
   return contactMessageRepository.findById(id).orElse(null);
}

public ContactMessage saveContactMessage(ContactMessage contactMessage) {
   return contactMessageRepository.save(contactMessage);
}

public void deleteContactMessage(Long id) {
   contactMessageRepository.deleteById(id);
}
}