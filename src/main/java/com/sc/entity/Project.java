package com.sc.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "projects")
public class Project {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String name;
	 private String type;
	 private String location;
	 private String size;
	 private String status;
	 private String imageUrl;
	 private String description;
}







