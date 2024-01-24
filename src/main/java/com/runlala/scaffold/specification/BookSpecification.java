package com.runlala.scaffold.specification;

import com.runlala.scaffold.dto.filter.BookFilter;
import com.runlala.scaffold.entity.Book;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BookSpecification {
    public static Specification<Book> filter(BookFilter bookFilter) {
        if (bookFilter == null) {
            return null;
        }
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (bookFilter.getName() != null) {
                predicates.add(builder.like(root.get("name"), "%" + bookFilter.getName() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
