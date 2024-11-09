package com.sc.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "team_members")
public class TeamMember {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 private String name;
 private String role;
 private String imageUrl;
 
 @Embedded
 private SocialLinks socialLinks;
}

@Embeddable
@Data
class SocialLinks {
 private String facebook;
 private String twitter;
 private String linkedin;
}
