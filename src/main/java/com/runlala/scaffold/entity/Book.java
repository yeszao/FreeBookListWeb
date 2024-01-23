package com.runlala.scaffold.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "books")
public class Book extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long authorId;
}