package com.sc.controller;
import com.sc.entity.Project;
import com.sc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	@Autowired
	 private ProjectService projectService;

	 @GetMapping
	 public List<Project> getAllProjects() {
	     return projectService.getAllProjects();
	 }

	 @GetMapping("/{id}")
	 public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
	     Project project = projectService.getProjectById(id);
	     return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
	 }

	 @PostMapping
	 public Project createProject(@RequestBody Project project) {
	     return projectService.saveProject(project);
	 }

	 @PutMapping("/{id}")
	 public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
	     Project project = projectService.getProjectById(id);
	     if (project == null) {
	         return ResponseEntity.notFound().build();
	     }
	     project.setName(projectDetails.getName());
	     project.setType(projectDetails.getType());
	     project.setLocation(projectDetails.getLocation());
	     project.setSize(projectDetails.getSize());
	     project.setStatus(projectDetails.getStatus());
	     project.setImageUrl(projectDetails.getImageUrl());
	     project.setDescription(projectDetails.getDescription());
	     return ResponseEntity.ok(projectService.saveProject(project));
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
	     Project project = projectService.getProjectById(id);
	     if (project == null) {
	         return ResponseEntity.notFound().build();
	     }
	     projectService.deleteProject(id);
	     return ResponseEntity.ok().build();
	 }
}






