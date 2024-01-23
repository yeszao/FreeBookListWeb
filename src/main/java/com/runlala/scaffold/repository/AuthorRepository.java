package com.runlala.scaffold.repository;

import com.runlala.scaffold.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
