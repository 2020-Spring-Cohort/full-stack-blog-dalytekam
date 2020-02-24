package org.wcci.blog.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long categoryId;
    @NotNull
    private String categoryName;
    @ManyToMany(mappedBy = "postCategories")
    private Collection<Post> categoryPosts =new ArrayList<>();

    public Category() {
    }

    public Category(String categoryName) {

        this.categoryName = categoryName;

    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Collection<Post> getCategoryPosts() {
        return categoryPosts;
    }
}
