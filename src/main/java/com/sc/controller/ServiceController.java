package com.sc.controller;
import com.sc.entity.*;
import com.sc.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
	@Autowired
	 private ServiceService serviceService;

	 @GetMapping
	 public List<Services> getAllServices() {
	     return serviceService.getAllServices();
	 }

	 @GetMapping("/{id}")
	 public ResponseEntity<Services> getServiceById(@PathVariable Long id) {
	     Services service = serviceService.getServiceById(id);
	     return service != null ? ResponseEntity.ok(service) : ResponseEntity.notFound().build();
	 }

	 @PostMapping
	 public Services createService(@RequestBody Services service) {
	     return serviceService.saveService(service);
	 }

	 @PutMapping("/{id}")
	 public ResponseEntity<Services> updateService(@PathVariable Long id, @RequestBody Services serviceDetails) {
	     Services service = serviceService.getServiceById(id);
	     if (service == null) {
	         return ResponseEntity.notFound().build();
	     }
	     service.setTitle(serviceDetails.getTitle());
	     service.setDescription(serviceDetails.getDescription());
	     service.setIconName(serviceDetails.getIconName());
	     return ResponseEntity.ok(serviceService.saveService(service));
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteService(@PathVariable Long id) {
	     Services service = serviceService.getServiceById(id);
	     if (service == null) {
	         return ResponseEntity.notFound().build();
	     }
	     serviceService.deleteService(id);
	     return ResponseEntity.ok().build();
	 }
}