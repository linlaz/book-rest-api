package com.lintech.maximum.controller;

import com.lintech.maximum.model.Author;
import com.lintech.maximum.model.Book;
import com.lintech.maximum.service.inter.BookInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookInter bookInter;

    @GetMapping()
    public ResponseEntity<Map> findAll(){
        return new ResponseEntity<>(bookInter.findAll(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Map> save(@RequestBody Book book){
        System.out.println(book);
        return new ResponseEntity<>(bookInter.save(book),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map> findById(@PathVariable("id")Long id){
        return new ResponseEntity<>(bookInter.findById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map> deleteById(@PathVariable("id")Long id){
        return new ResponseEntity<>(bookInter.deleteById(id),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Map> deleteById(){
        return new ResponseEntity<>(bookInter.deleteAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}/author")
    public ResponseEntity<Map> updateBookAuthorById(@PathVariable("id") Long id, @RequestBody Book book){
        return new ResponseEntity<>(bookInter.updateBookAuthorById(id,book),HttpStatus.OK);
    }

}
