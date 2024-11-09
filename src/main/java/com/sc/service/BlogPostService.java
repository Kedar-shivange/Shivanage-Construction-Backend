package com.sc.service;

import com.sc.entity.BlogPost;
import com.sc.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogPostService {
@Autowired
private BlogPostRepository blogPostRepository;

public List<BlogPost> getAllBlogPosts() {
   return blogPostRepository.findAll();
}

public BlogPost getBlogPostById(Long id) {
   return blogPostRepository.findById(id).orElse(null);
}

public BlogPost saveBlogPost(BlogPost blogPost) {
   return blogPostRepository.save(blogPost);
}

public void deleteBlogPost(Long id) {
   blogPostRepository.deleteById(id);
}
}