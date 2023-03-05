package com.lintech.maximum.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_author",length = 200)
    private String name;

    @Column(name = "desc_author", length = 200)
    private String desc;

    @ManyToMany( mappedBy = "authors")
    private List<Book> books;

}
