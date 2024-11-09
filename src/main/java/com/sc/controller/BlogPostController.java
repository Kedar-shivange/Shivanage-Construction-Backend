package com.sc.controller;

import com.sc.entity.BlogPost;
import com.sc.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog-posts")
@CrossOrigin(origins = "http://localhost:3000") // Enable CORS for this controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        return blogPost != null ? ResponseEntity.ok(blogPost) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPostDetails) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        blogPost.setTitle(blogPostDetails.getTitle());
        blogPost.setExcerpt(blogPostDetails.getExcerpt());
        blogPost.setContent(blogPostDetails.getContent());
        blogPost.setImageUrl(blogPostDetails.getImageUrl());
        blogPost.setDate(blogPostDetails.getDate());
        blogPost.setAuthor(blogPostDetails.getAuthor());
        blogPost.setComments(blogPostDetails.getComments());
        return ResponseEntity.ok(blogPostService.saveBlogPost(blogPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.ok().build();
    }
}
