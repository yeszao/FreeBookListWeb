package com.runlala.scaffold.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "tags")
@EqualsAndHashCode(callSuper = true)
public class Tag extends EntityBase {
    @Column(nullable = false)
    private String name;
}