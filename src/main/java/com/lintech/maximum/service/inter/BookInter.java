package com.lintech.maximum.service.inter;

import com.lintech.maximum.model.Author;
import com.lintech.maximum.model.Book;

import java.util.Map;

public interface BookInter extends CrudGlobal<Book> {
    public Map<String,Object> deleteAll();

    public Map<String,Object> updateBookAuthorById(Long id, Book book);
}
