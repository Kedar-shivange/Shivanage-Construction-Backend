package com.sc.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "blog_posts")
public class BlogPost {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String title;
private String excerpt;
private String content;
private String imageUrl;
private LocalDate date;
private String author;
private int comments;
}