package org.wcci.blog.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
@Entity
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @NotNull
    private String authorName;
    @OneToMany(mappedBy = "postAuthor")
    private Collection<Post> authorPosts = new ArrayList<>();



    public Author(String authorName) {

        this.authorName = authorName;

    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Collection<Post> getAuthorPosts() {
        return authorPosts;
    }
    public Author() {
    }
}
