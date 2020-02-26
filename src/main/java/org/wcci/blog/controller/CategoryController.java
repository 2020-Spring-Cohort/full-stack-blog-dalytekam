package org.wcci.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("/categories")

    public String getCategories(){
        return "categories";
    }

    @GetMapping("/add-category")

    public String addCategory(){
        return "add-category";
    }
}
