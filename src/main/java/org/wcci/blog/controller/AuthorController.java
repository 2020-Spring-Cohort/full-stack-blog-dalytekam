package org.wcci.blog.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.dao.AuthorRepository;
import org.wcci.blog.entities.Author;

@Controller
public class AuthorController {

private AuthorRepository authorRepository;



    public AuthorController(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }







    @GetMapping("/authors")

    public String getAuthors(Model model)
            //Model model,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5")int size,
//            @RequestParam(name ="keyword",defaultValue = "")String keyword
//    ){
//        Page<Author> authorsPage = authorRepository.search("%"+keyword+"%",PageRequest.of(page, size));
//        int[] pagesCount = new int[authorsPage.getTotalPages()];
//        model.addAttribute("authors",authorsPage.getContent());
//        model.addAttribute("pages",pagesCount);
//        model.addAttribute("size", size);
//        model.addAttribute("currentPage",page);
//        model.addAttribute("keyword",keyword);
    {
        model.addAttribute("ListOfAuthors",authorRepository.findAll());
        return "authors";
    }


    @GetMapping("/add-author")
    public String addAuthor(){
        return "add-author";
    }


    @PostMapping("/save-author")
    public String saveAuthor(@RequestParam String authorName){
        Author authorAdded = new Author(authorName);
        authorRepository.save(authorAdded);


        return "succes";
    }



}
