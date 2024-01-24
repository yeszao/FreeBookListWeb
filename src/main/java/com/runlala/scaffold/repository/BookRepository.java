package com.runlala.scaffold.repository;

import com.runlala.scaffold.entity.Book;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
    Window<Book> getBookBy(ScrollPosition position, Limit limit, Sort sort);
}
