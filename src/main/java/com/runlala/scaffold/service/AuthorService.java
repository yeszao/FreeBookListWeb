package com.runlala.scaffold.service;

import com.runlala.scaffold.dto.filter.AuthorFilterDto;
import com.runlala.scaffold.dto.out.AuthorOutDto;
import com.runlala.scaffold.entity.Author;
import com.runlala.scaffold.mapper.AuthorMapper;
import com.runlala.scaffold.repository.AuthorRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public Page<AuthorOutDto> getAll(AuthorFilterDto authorFilterDto, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Author> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(authorFilterDto.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + authorFilterDto.getName() + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Author> authors =  authorRepository.findAll(spec, pageable);
        return authorMapper.pageToDto(authors);
    }
}