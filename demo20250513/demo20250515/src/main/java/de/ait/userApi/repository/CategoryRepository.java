package de.ait.userApi.repository;

import de.ait.userApi.model.Category;
import de.ait.userApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
}
