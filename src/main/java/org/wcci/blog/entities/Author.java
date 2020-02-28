package org.wcci.blog.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @NotNull
    private String authorName;
    @OneToMany(mappedBy = "postAuthor")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Post> authorPosts = new HashSet<>();



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId.equals(author.authorId) &&
                authorName.equals(author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName);
    }
}
