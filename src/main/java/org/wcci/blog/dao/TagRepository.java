package org.wcci.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wcci.blog.entities.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
