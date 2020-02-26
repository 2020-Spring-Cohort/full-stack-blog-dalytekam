package org.wcci.blog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.wcci.blog.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("select a from Author a where a.authorName like :x")
    Page<Author> search(@Param("x") String kw, Pageable pageable);
}
