package com.sc.service;

import com.sc.entity.Testimonial;
import com.sc.repository.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestimonialService {
	@Autowired
	 private TestimonialRepository testimonialRepository;

	 public List<Testimonial> getAllTestimonials() {
	     return testimonialRepository.findAll();
	 }

	 public Testimonial getTestimonialById(Long id) {
	     return testimonialRepository.findById(id).orElse(null);
	 }

	 public Testimonial saveTestimonial(Testimonial testimonial) {
	     return testimonialRepository.save(testimonial);
	 }

	 public void deleteTestimonial(Long id) {
	     testimonialRepository.deleteById(id);
	 }
}

