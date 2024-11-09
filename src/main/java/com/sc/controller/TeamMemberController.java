package com.sc.controller;
import com.sc.entity.TeamMember;
import com.sc.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/team-members")
public class TeamMemberController {
 @Autowired
 private TeamMemberService teamMemberService;

 @GetMapping
 public List<TeamMember> getAllTeamMembers() {
     return teamMemberService.getAllTeamMembers();
 }

 @GetMapping("/{id}")
 public ResponseEntity<TeamMember> getTeamMemberById(@PathVariable Long id) {
     TeamMember teamMember = teamMemberService.getTeamMemberById(id);
     return teamMember != null ? ResponseEntity.ok(teamMember) : ResponseEntity.notFound().build();
 }

 @PostMapping
 public TeamMember createTeamMember(@RequestBody TeamMember teamMember) {
     return teamMemberService.saveTeamMember(teamMember);
 }

 @PutMapping("/{id}")
 public ResponseEntity<TeamMember> updateTeamMember(@PathVariable Long id, @RequestBody TeamMember teamMemberDetails) {
     TeamMember teamMember = teamMemberService.getTeamMemberById(id);
     if (teamMember == null) {
         return ResponseEntity.notFound().build();
     }
     teamMember.setName(teamMemberDetails.getName());
     teamMember.setRole(teamMemberDetails.getRole());
     teamMember.setImageUrl(teamMemberDetails.getImageUrl());
     teamMember.setSocialLinks(teamMemberDetails.getSocialLinks());
     return ResponseEntity.ok(teamMemberService.saveTeamMember(teamMember));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteTeamMember(@PathVariable Long id) {
     TeamMember teamMember = teamMemberService.getTeamMemberById(id);
     if (teamMember == null) {
         return ResponseEntity.notFound().build();
     }
     teamMemberService.deleteTeamMember(id);
     return ResponseEntity.ok().build();
 }
}
