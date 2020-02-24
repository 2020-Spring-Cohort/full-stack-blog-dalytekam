package org.wcci.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wcci.blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
