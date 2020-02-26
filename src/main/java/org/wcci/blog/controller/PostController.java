package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @GetMapping("/all-posts")

    public String getPosts(){
        return "all-posts";
    }


    @GetMapping("/single-post")

    public String getSinglePost(){
        return "single-post";
    }


    @GetMapping("/add-post")

    public String addPost(){
        return "add-post";
    }



}
