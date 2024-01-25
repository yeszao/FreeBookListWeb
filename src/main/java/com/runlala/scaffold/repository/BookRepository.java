package com.runlala.scaffold.repository;

import com.runlala.scaffold.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = {"author"})
    Page<Book> findAll(Specification<Book> spec, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update books set random_order = FLOOR(RAND() * 2147483647)", nativeQuery = true)
    void updateRandomOrder();
}
