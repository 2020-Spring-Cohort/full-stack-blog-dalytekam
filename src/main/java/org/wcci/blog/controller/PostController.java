package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Post;
import org.wcci.blog.service.BlogServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PostController {
   private BlogServiceImpl blogServiceImpl;

    public PostController(BlogServiceImpl blogServiceImpl) {
        this.blogServiceImpl = blogServiceImpl;
    }

// Get all the posts
    @GetMapping("/all-posts")
    public String getPosts(Model model){
    List<Post> posts= blogServiceImpl.listOfAllPosts();
    model.addAttribute("posts",posts);
        return "all-posts";
    }


// Get single Post
    @GetMapping("/post/{id}")
    public String getSinglePost(@PathVariable Long id, Model model){
        Post retrievedPost = blogServiceImpl.findPostById(id);
        model.addAttribute("singlePost",retrievedPost);
        return "single-post";
    }

// Add a new Post
    @GetMapping("/add-post")
    public String addPost(){
        return "add-post";
    }

   // @PostMapping("/save-post")
   // public String savePost(@RequestParam String postTitle, @RequestParam String postBody, @RequestParam String postAuthorName){


       // Post postNewlyCreated = new Post(postTitle,postBody,postAuthor, LocalDateTime.now());
       // blogServiceImpl.saveAuthor(authorName);
        //return "succes";
   // }




}
