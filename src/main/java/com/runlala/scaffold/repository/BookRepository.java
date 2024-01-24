package com.runlala.scaffold.repository;

import com.runlala.scaffold.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> getAllBy(Pageable pageable);
}
