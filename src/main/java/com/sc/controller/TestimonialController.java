package com.sc.controller;
import com.sc.entity.Testimonial;
import com.sc.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {
	@Autowired
	 private TestimonialService testimonialService;

	 @GetMapping
	 public List<Testimonial> getAllTestimonials() {
	     return testimonialService.getAllTestimonials();
	 }

	 @GetMapping("/{id}")
	 public ResponseEntity<Testimonial> getTestimonialById(@PathVariable Long id) {
	     Testimonial testimonial = testimonialService.getTestimonialById(id);
	     return testimonial != null ? ResponseEntity.ok(testimonial) : ResponseEntity.notFound().build();
	 }

	 @PostMapping
	 public Testimonial createTestimonial(@RequestBody Testimonial testimonial) {
	     return testimonialService.saveTestimonial(testimonial);
	 }

	 @PutMapping("/{id}")
	 public ResponseEntity<Testimonial> updateTestimonial(@PathVariable Long id, @RequestBody Testimonial testimonialDetails) {
	     Testimonial testimonial = testimonialService.getTestimonialById(id);
	     if (testimonial == null) {
	         return ResponseEntity.notFound().build();
	     }
	     testimonial.setName(testimonialDetails.getName());
	     testimonial.setRole(testimonialDetails.getRole());
	     testimonial.setImageUrl(testimonialDetails.getImageUrl());
	     testimonial.setQuote(testimonialDetails.getQuote());
	     return ResponseEntity.ok(testimonialService.saveTestimonial(testimonial));
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id) {
	     Testimonial testimonial = testimonialService.getTestimonialById(id);
	     if (testimonial == null) {
	         return ResponseEntity.notFound().build();
	     }
	     testimonialService.deleteTestimonial(id);
	     return ResponseEntity.ok().build();
	 }
}