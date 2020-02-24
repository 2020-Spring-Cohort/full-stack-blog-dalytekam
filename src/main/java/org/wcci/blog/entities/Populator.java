package org.wcci.blog.entities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.wcci.blog.dao.AuthorRepository;
import org.wcci.blog.dao.CategoryRepository;
import org.wcci.blog.dao.PostRepository;
import org.wcci.blog.dao.TagRepository;

@Component
public class Populator implements CommandLineRunner {
    private PostRepository postRepository;
    private AuthorRepository authorRepository;
    private TagRepository tagRepository;
    private CategoryRepository categoryRepository;

    public Populator(PostRepository postRepository, AuthorRepository authorRepository, TagRepository tagRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
        this.tagRepository = tagRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // Create categories
        Category food = new Category("food");
        Category drink = new Category("drink");
        Category car = new Category("car");
        //save categories
        categoryRepository.save(food);
        categoryRepository.save(drink);
        categoryRepository.save(car);

        // Create tags
        Tag hot = new Tag("hot");
        Tag trendy = new Tag("trendy");
        Tag mom = new Tag("mom");
        Tag summer = new Tag("summer");
        // Save tags
        tagRepository.save(hot);
        tagRepository.save(trendy);
        tagRepository.save(mom);
        tagRepository.save(summer);

        //Create authors
        Author daly = new Author("Daly");
        Author richy = new Author("Richy");
        Author tekam = new Author("Tekam");
        Author kuate = new Author("Kuate");

        //Save authors
        authorRepository.save(richy);
        authorRepository.save(daly);
        authorRepository.save(tekam);
        authorRepository.save(kuate);

        // Create post
        Post post1 =new Post("My first Post","is simply dummy text of the printing and ",daly);
        Post post2 =new Post("My first Post","is simply dummy ext of the printing a",richy);
        Post post3 =new Post("My first Post","is simply dummy text of the printing and t",tekam);

        //Add categories to post
        post1.getPostCategories().add(food);
        post1.getPostCategories().add(drink);
        post2.getPostCategories().add(drink);
        post2.getPostCategories().add(car);
        post3.getPostCategories().add(car);
        post1.getPostCategories().add(car);

        // Add tags to post
        post1.getPostTags().add(hot);
        post1.getPostTags().add(mom);
        post1.getPostTags().add(trendy);
        post2.getPostTags().add(hot);
        post2.getPostTags().add(summer);
        post2.getPostTags().add(mom);

        // save post
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);


        postRepository.findAll().forEach(post -> {
                   System.out.println(post.getPostTitle());
                   System.out.println(post.getPostBody());


            });


                }





}
