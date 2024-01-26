package com.runlala.scaffold.repository;

import com.runlala.scaffold.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findAllByBookId(Long bookId);
}
