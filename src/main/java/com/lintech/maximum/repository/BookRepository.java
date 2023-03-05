package com.lintech.maximum.repository;

import com.lintech.maximum.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByPublisherId(Long id);
}
