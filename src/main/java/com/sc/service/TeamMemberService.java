package com.sc.service;
import com.sc.entity.*;
import com.sc.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamMemberService {
 @Autowired
 private TeamMemberRepository teamMemberRepository;

 public List<TeamMember> getAllTeamMembers() {
     return teamMemberRepository.findAll();
 }

 public TeamMember getTeamMemberById(Long id) {
     return teamMemberRepository.findById(id).orElse(null);
 }

 public TeamMember saveTeamMember(TeamMember teamMember) {
     return teamMemberRepository.save(teamMember);
 }

 public void deleteTeamMember(Long id) {
     teamMemberRepository.deleteById(id);
 }
}
