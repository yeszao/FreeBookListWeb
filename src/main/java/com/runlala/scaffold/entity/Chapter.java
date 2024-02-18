package com.runlala.scaffold.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "chapters")
@EqualsAndHashCode(callSuper = true)
public class Chapter extends EntityBase {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String href;

    @Column(nullable = false)
    private String audioUri;

    @Column(nullable = false)
    private String originAudioUrl;

    @Column(nullable = false)
    private Integer sort;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
}