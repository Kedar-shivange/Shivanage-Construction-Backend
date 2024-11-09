package com.sc.service;
import com.sc.entity.Services;
import org.springframework.stereotype.Service;
import com.sc.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class ServiceService {
@Autowired
private ServiceRepository serviceRepository;

public List<Services> getAllServices() {
   return serviceRepository.findAll();
}

public Services getServiceById(Long id) {
   return serviceRepository.findById(id).orElse(null);
}

public Services saveService(Services service) {
   return serviceRepository.save(service);
}

public void deleteService(Long id) {
   serviceRepository.deleteById(id);
}
}