package com.lintech.maximum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "publisher")
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_publisher",nullable = false,unique = true,length = 150)
    private String name;
    @Column(name = "address_publisher",length = 150)
    private String address;

    @Column(name = "desc_publisher",length = 200)
    private String desc;

    @JsonIgnore
    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Book> books;
}
