package com.runlala.scaffold.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "books")
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
    private String chapterCount;

    @Column(nullable = false)
    private String lang;

    @Column(nullable = false)
    private Long authorId;
}