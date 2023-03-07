package com.lintech.maximum.controller;

import com.lintech.maximum.model.Author;
import com.lintech.maximum.service.inter.AuthorInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorInter authorInter;

    @GetMapping()
    public ResponseEntity<Map> findAll(){
        return new ResponseEntity<>(authorInter.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Map> save(@RequestBody Author author){
        return new ResponseEntity<>(authorInter.save(author),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map> updateById(@PathVariable("id")Long id,@RequestBody Author author){
        return new ResponseEntity<>(authorInter.updateById(id,author),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map> deleteById(@PathVariable("id") Long id){
        return new ResponseEntity<>(authorInter.deleteById(id),HttpStatus.OK);
    }



}
