package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {

    @GetMapping("/tags")

    public String getTags(){
        return "tags";
    }


    @GetMapping("/add-tag")

    public String addTag(){
        return "add-tag";
    }


}
