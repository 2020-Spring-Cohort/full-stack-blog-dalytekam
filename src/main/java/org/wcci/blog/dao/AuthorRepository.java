package org.wcci.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wcci.blog.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
