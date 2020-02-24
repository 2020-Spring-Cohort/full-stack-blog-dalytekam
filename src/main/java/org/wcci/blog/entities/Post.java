package org.wcci.blog.entities;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Tag;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NotNull
    private String postTitle;
    @NotNull
    @Column(columnDefinition="TEXT")
    private String postBody;
    @ManyToOne
    private Author postAuthor;
    @ManyToMany
    private Collection<Category> postCategories = new ArrayList<>();
    @ManyToMany
    private Collection<Tag> postTags =new ArrayList<>();

    public Post() {
    }

    public Post(String postTitle, String postBody, Author postAuthor) {

        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postAuthor = postAuthor;


    }

    public Long getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public Author getPostAuthor() {
        return postAuthor;
    }

    public Collection<Category> getPostCategories() {
        return postCategories;
    }

    public Collection<Tag> getPostTags() {
        return postTags;
    }
}
