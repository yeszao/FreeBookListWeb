package com.runlala.scaffold.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "books", indexes = {
        @Index(name = "idx_books_random_order", columnList = "randomOrder")
})
@EqualsAndHashCode(callSuper = true)
public class Book extends EntityBase {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String issued;

    @Column(nullable = false)
    private String coverUri;

    @Column(nullable = false)
    private String epubUri;

    @Column(nullable = false)
    private Integer chapterCount;

    @Column(nullable = false)
    private String lang;

    @Column(nullable = false)
    private Boolean mostFamous;

    @Column(nullable = false)
    private Integer randomOrder;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    @ManyToMany
    @BatchSize(size = 10)
    @JoinTable(name = "book_tag_relation",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "tagId"))
    private List<Tag> tags = new ArrayList<>();
}