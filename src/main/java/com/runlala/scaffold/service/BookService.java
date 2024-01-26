package com.runlala.scaffold.service;

import com.runlala.scaffold.dto.filter.BookFilterDto;
import com.runlala.scaffold.dto.out.BookOutDto;
import com.runlala.scaffold.entity.Book;
import com.runlala.scaffold.mapper.BookMapper;
import com.runlala.scaffold.repository.BookRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Page<BookOutDto> getAll(BookFilterDto bookFilterDto, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "randomOrder");
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Book> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(bookFilterDto.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + bookFilterDto.getName() + "%"));
            }

            if (Objects.nonNull(bookFilterDto.getMostFamous())) {
                predicates.add(criteriaBuilder.equal(root.get("mostFamous"), bookFilterDto.getMostFamous()));
            }

            if (Objects.nonNull(bookFilterDto.getAuthorId()) && bookFilterDto.getAuthorId() > 0) {
                predicates.add(criteriaBuilder.equal(root.get("author").get("id"), bookFilterDto.getAuthorId()));
            }

            if (Objects.nonNull(bookFilterDto.getTagId()) && bookFilterDto.getTagId() > 0) {
                predicates.add(criteriaBuilder.equal(root.get("tags").get("id"), bookFilterDto.getTagId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Book> books =  bookRepository.findAll(spec, pageable);
        return bookMapper.pageToDto(books);
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000, initialDelay = 60 * 60 * 1000)
    public void updateRandomOrder() {
        bookRepository.updateRandomOrder();
        log.info("Updated random order");
    }
}