package com.lintech.maximum.service.impl;

import com.lintech.maximum.model.Book;
import com.lintech.maximum.model.Publisher;
import com.lintech.maximum.repository.BookRepository;
import com.lintech.maximum.repository.PublisherRepository;
import com.lintech.maximum.service.inter.BookInter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BookService implements BookInter {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    public Map findAll() {
        Map<String,Object> map = new HashMap();
        List list = bookRepository.findAll();

        try {
            map.put("data",list);
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }

    }
    public Map save(Book obj){
        Map<String,Object> map = new HashMap();
        try{
            Publisher pub = publisherRepository.getPublisherById(obj.getPublisher().getId());

            if (pub == null) {
                throw new Exception("publisher not found");
            }
            obj.setPublisher(pub);
            Book publisherObj = bookRepository.save(obj);
            map.put("data",publisherObj);
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }
    }
    public Map findById(Long id){
        Map<String,Object> map = new HashMap();
        try{
            map.put("data", bookRepository.findById(id));
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }

    }
    public Map deleteById(Long id){
        Map<String,Object> map = new HashMap();
        try{
            bookRepository.deleteById(id);
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e){
            map.put("code",HttpStatus.BAD_REQUEST);
            map.put("message",e.getMessage());
            return map;
        }

    }
    public Map updateById(Long id, Book book){
        Map<String,Object> map = new HashMap();
        try {
            map.put("code", HttpStatus.OK);
            map.put("message","success");
            return map;
        }catch (Exception e) {
            map.put("code", HttpStatus.BAD_REQUEST);
            map.put("message", e.getMessage());
            return map;
        }
    }
}
